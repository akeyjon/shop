package com.miaoshashop.miaoshashop.service.impl;

import com.miaoshashop.miaoshashop.common.error.BusinessException;
import com.miaoshashop.miaoshashop.common.error.ErrorEnum;
import com.miaoshashop.miaoshashop.common.validator.ValidatorImpl;
import com.miaoshashop.miaoshashop.common.validator.ValidatorResult;
import com.miaoshashop.miaoshashop.dao.ItemDOMapper;
import com.miaoshashop.miaoshashop.dao.ItemStockDOMapper;
import com.miaoshashop.miaoshashop.dataobject.ItemStockDO;
import com.miaoshashop.miaoshashop.service.ItemService;
import com.miaoshashop.miaoshashop.service.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private ItemDOMapper itemDOMapper;

    @Autowired
    private ItemStockDOMapper itemStockDOMapper;

    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) throws BusinessException{
        //检验入参
        ValidatorResult result = validator.validate(itemModel);
        if(result.isHasError()){
            throw new BusinessException(ErrorEnum.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
        }

        //转化model 至 dataObject


        return null;
    }

    @Override
    public List<ItemModel> listItem() {
        return null;
    }

    @Override
    public ItemModel getItemModelById(int id) {
        return null;
    }

    @Transactional
    @Override
    public boolean dcreaseStock(int itemId, int amount) throws BusinessException {
        int affectRows = itemStockDOMapper.descreaseStock(itemId, amount);
        if(affectRows>0){
            //更新库存成功
            return true;
        }else {
            return false;
        }
//        ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(itemId);
//        Integer stock = itemStockDO.getStock();
//        if(stock < amount){
//            throw new BusinessException(ErrorEnum.PARAMETER_VALIDATION_ERROR,"库存数量不够");
//        }
//        itemStockDO.setStock(stock - amount);
//        int i = itemStockDOMapper.updateByPrimaryKeySelective(itemStockDO);
//        return i>0;
    }
}
