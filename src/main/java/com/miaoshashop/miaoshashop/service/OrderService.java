package com.miaoshashop.miaoshashop.service;

import com.miaoshashop.miaoshashop.common.error.BusinessException;
import com.miaoshashop.miaoshashop.service.model.OrderModel;

public interface OrderService {

    /**
     *创建订单
     * @param userId
     * @param itemId
     * @param amount
     * @return
     */
    OrderModel createOrder(int userId, int itemId, int amount) throws BusinessException;
}
