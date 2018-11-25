package com.xhh.sell_lx.dataobject.mapper;

import com.xhh.sell_lx.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * luokai
 * 2018/11/24 17:16
 */
public interface ProductCategoryMapper {
    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType = VARCHAR},#{categoryType,jdbcType = INTEGER} )   ")
    int insertByMap(Map<String,Object>map);

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType = VARCHAR},#{categoryType,jdbcType = INTEGER} )  ")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);


    @Select("select * from product_category where category_name = #{categoryName} ")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name = #{categoryName} where  category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") int categoryType);


    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);

    ProductCategory selectByCategoryType( Integer categoryType);
}
