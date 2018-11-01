package com.xhh.sell_lx.service.impl;

import com.xhh.sell_lx.dataobject.ProductCategory;
import com.xhh.sell_lx.repository.ProductCategoryRepository;
import com.xhh.sell_lx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 类目
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> productCategoryOptional = productCategoryRepository.findById(categoryId);
        if(!productCategoryOptional.isPresent()){
            return null ;
        }
         return productCategoryOptional.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
