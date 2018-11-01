package com.xhh.sell_lx.service.impl;

import com.xhh.sell_lx.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        log.info("productCategory:{}",productCategory.toString());
        Assert.assertEquals(new Integer(1) ,productCategory.getCategoryId());

    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
        Assert.assertNotEquals(0,productCategories.size());

    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
        Assert.assertNotEquals(0,productCategoryList);
    }

    @Test
    public void save() {
        ProductCategory productCategory =new ProductCategory("女士专享",4);
        ProductCategory category = categoryService.save(productCategory);
        Assert.assertNotNull(category);
    }
}