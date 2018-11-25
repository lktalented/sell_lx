package com.xhh.sell_lx.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * luokai
 * 2018/10/29 0029 上午 11:24
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -55404673767841889L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
