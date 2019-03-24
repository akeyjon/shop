package com.miaoshashop.miaoshashop.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品
 */
@Getter
@Setter
public class ItemModel {

    private int id;

    //商品名称
    @NotBlank(message = "商品名称不能为空")
    private String title;

    //价格
    @NotNull(message = "商品价格不能为空")
    @Min(value = 0 ,message = "商品价格必须大于0")
    private BigDecimal price;

    //库存
    @NotNull(message = "库存不能为空")
    private int stock;

    //描述
    @NotBlank(message = "商品描述不能为空")
    private String description;

    //销量
    private int sales;

    //图片url
    @NotBlank(message = "商品图片不能为空")
    private String imgUrl;
}
