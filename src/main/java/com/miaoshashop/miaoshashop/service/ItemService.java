package com.miaoshashop.miaoshashop.service;

import com.miaoshashop.miaoshashop.common.error.BusinessException;
import com.miaoshashop.miaoshashop.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    /**
     * 创建商品
     * @param itemModel
     * @return
     */
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    /**
     * 商品列表展示
     * @return
     */
    List<ItemModel> listItem();

    /**
     * 商品详情
     * @param id
     * @return
     */
    ItemModel getItemModelById(int id);

    /**
     * 减库存
     * @param itemId
     * @param amount
     * @return
     */
    boolean dcreaseStock(int itemId, int amount) throws BusinessException;

    int updateItem(ItemModel itemModel);

}
