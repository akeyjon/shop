package com.miaoshashop.miaoshashop.service.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

//订单模型
@Getter
@Setter
public class OrderModel {

    //订单id 具有业务意义
    private String id;

    //用户id
    private int userId;

    //关联的商品id
    private int itemId;

    //商品单价
    private BigDecimal itemPrice;

    //购买的数量
    private int amount;

    //订单金额
    private BigDecimal orderPrice;

}
