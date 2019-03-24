package com.miaoshashop.miaoshashop.controller.viewobject;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ItemVO implements Serializable {
    private static final long serialVersionUID = 3316913100964097282L;
    private String title;

    //价格
    private BigDecimal price;

    //库存
    private int stock;

    //描述
    private String desription;

    //销量
    private int sales;

    //图片url
    private String imgeUrl;
}
