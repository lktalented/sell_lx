package com.xhh.sell_lx.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品表单
 * Created by 廖师兄
 * 2017-05-09 11:30
 */
@Data
public class ProductForm {

    private String productId;

    /** 名字. */
    @NotBlank(message = "名称必填")
    private String productName;

    /** 单价. */
    @NotNull(message = "单价必填")
    private BigDecimal productPrice;

    /** 库存. */
    @NotNull(message = "库存必填")
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    @NotNull(message = "类目必填")
    private Integer categoryType;

}
