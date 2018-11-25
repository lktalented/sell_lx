package com.xhh.sell_lx.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情视图对象
 * luokai
 * 2018/10/29 0029 上午 11:14
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 7937937783505279992L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
