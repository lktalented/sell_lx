package com.xhh.sell_lx.service.impl;

import com.xhh.sell_lx.dataobject.ProductCategory;
import com.xhh.sell_lx.dataobject.mapper.ProductCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap(){
        Map<String,Object>map = new HashMap<>();
        map.put("categoryName","师兄最不爱");
        map.put("categoryType",101);
        int result = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,result);

    }

    @Test
    public void insetByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(102);
        int result = productCategoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType(){
        ProductCategory result = productCategoryMapper.findByCategoryType(102);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> categoryList = productCategoryMapper.findByCategoryName("师兄最不爱");
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void updateByCategoryType(){
        int result = productCategoryMapper.updateByCategoryType("师兄最不爱的分类", 101);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteByCategoryType(){
        int result = productCategoryMapper.deleteByCategoryType(101);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory productCategory = productCategoryMapper.selectByCategoryType(102);
        Assert.assertNotNull(productCategory);
    }
}