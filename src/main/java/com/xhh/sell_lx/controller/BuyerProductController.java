package com.xhh.sell_lx.controller;

import com.xhh.sell_lx.dataobject.ProductCategory;
import com.xhh.sell_lx.dataobject.ProductInfo;
import com.xhh.sell_lx.service.CategoryService;
import com.xhh.sell_lx.service.ProductService;
import com.xhh.sell_lx.utils.ResultVOUtil;
import com.xhh.sell_lx.vo.ProductInfoVO;
import com.xhh.sell_lx.vo.ProductVO;
import com.xhh.sell_lx.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * luokai
 * 2018/10/29 0029 上午 11:39
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目（java8,lambda）
        List<Integer> categoryTypeList =
                productInfoList.stream()
                        .map(e -> e.getCategoryType())
                        .collect(Collectors.toList());
        List<ProductCategory> productCategoryList =
                categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for ( ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }


}
