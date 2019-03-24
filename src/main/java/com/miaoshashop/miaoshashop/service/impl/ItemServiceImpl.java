package com.miaoshashop.miaoshashop.service.impl;

import com.miaoshashop.miaoshashop.common.error.BusinessException;
import com.miaoshashop.miaoshashop.common.error.ErrorEnum;
import com.miaoshashop.miaoshashop.common.validator.ValidatorImpl;
import com.miaoshashop.miaoshashop.common.validator.ValidatorResult;
import com.miaoshashop.miaoshashop.dao.ItemDOMapper;
import com.miaoshashop.miaoshashop.dao.ItemStockDOMapper;
import com.miaoshashop.miaoshashop.dataobject.ItemDO;
import com.miaoshashop.miaoshashop.dataobject.ItemStockDO;
import com.miaoshashop.miaoshashop.service.ItemService;
import com.miaoshashop.miaoshashop.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
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
        ItemDO itemDO = convertFromItemModel(itemModel);
        itemDOMapper.insertSelective(itemDO);
        ItemStockDO itemStockDO = new ItemStockDO();
        itemStockDO.setItemId(itemDO.getId());
        itemStockDO.setStock(itemModel.getStock());
        itemStockDOMapper.insertSelective(itemStockDO);
        return null;
    }

    @Override
    public List<ItemModel> listItem() {
        return null;
    }

    @Override
    public ItemModel getItemModelById(int id) {
        ItemDO itemDO = itemDOMapper.selectByPrimaryKey(id);
        ItemStockDO itemStockDO = itemStockDOMapper.selectByItemId(id);
       return  convertFromDO(itemDO, itemStockDO);
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

    @Override
    public int updateItem(ItemModel itemModel) {
        ItemDO itemDO = convertFromItemModel(itemModel);
        return itemDOMapper.updateByPrimaryKeySelective(itemDO);
    }

    private ItemDO convertFromItemModel(ItemModel itemModel){
        if(itemModel == null){
            return null;
        }

        ItemDO itemDO = new ItemDO();
        BeanUtils.copyProperties(itemModel, itemDO);
        itemDO.setPrice(itemModel.getPrice().doubleValue());
        return itemDO;
    }

    private ItemModel convertFromDO(ItemDO itemDO, ItemStockDO itemStockDO){
        if(itemDO == null){
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO, itemModel);
        itemModel.setPrice(new BigDecimal(itemDO.getPrice()));
        if(itemStockDO != null){
            itemModel.setStock(itemStockDO.getStock());
        }
        return itemModel;
    }


}
