package com.miaoshashop.miaoshashop.service.impl;

import com.miaoshashop.miaoshashop.common.error.BusinessException;
import com.miaoshashop.miaoshashop.common.error.ErrorEnum;
import com.miaoshashop.miaoshashop.dao.OrderInfoDOMapper;
import com.miaoshashop.miaoshashop.dao.SequenceInfoDOMapper;
import com.miaoshashop.miaoshashop.dataobject.OrderInfoDO;
import com.miaoshashop.miaoshashop.dataobject.SequenceInfoDO;
import com.miaoshashop.miaoshashop.service.ItemService;
import com.miaoshashop.miaoshashop.service.OrderService;
import com.miaoshashop.miaoshashop.service.UserService;
import com.miaoshashop.miaoshashop.service.model.ItemModel;
import com.miaoshashop.miaoshashop.service.model.OrderModel;
import com.miaoshashop.miaoshashop.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderInfoDOMapper orderInfoDOMapper;

    @Autowired
    private SequenceInfoDOMapper sequenceInfoDOMapper;

    @Override
    @Transactional
    public OrderModel createOrder(int userId, int itemId, int amount) throws BusinessException {
        //Assert.notNull(itemId,"商品不存在");
        //1.校验下单状态 下单商品是否存在， 用户是否合法， 购买数量是否正确
        ItemModel itemModel = itemService.getItemModelById(itemId);
        if(itemModel == null){
            throw new BusinessException(ErrorEnum.PARAMETER_VALIDATION_ERROR, "商品信息不存在");
        }

        UserModel userModel = userService.getUserById(userId);
        if(userModel == null){
            throw new BusinessException(ErrorEnum.PARAMETER_VALIDATION_ERROR, "用户信息不存在");
        }

        if(amount<=0 || amount>=100){
            throw new BusinessException(ErrorEnum.PARAMETER_VALIDATION_ERROR,"数量信息不正确");
        }

        //2.落单减库存  支付减库存
        boolean flag = itemService.dcreaseStock(itemId, amount);
        if(!flag){
            throw new BusinessException(ErrorEnum.PARAMETER_VALIDATION_ERROR, "库存不足");
        }

        //3.订单入库
        OrderModel orderModel = new OrderModel();
        orderModel.setItemId(itemId);
        orderModel.setUserId(userId);
        orderModel.setAmount(amount);
        orderModel.setItemPrice(itemModel.getPrice());
        orderModel.setOrderPrice(itemModel.getPrice().multiply(new BigDecimal(amount)));
        orderModel.setId(generateOrderId());
        OrderInfoDO orderInfoDO = convertFromOrderModelToOrderInfoDO(orderModel);
        orderInfoDOMapper.insertSelective(orderInfoDO);
        //对应商品表销量增加
        itemModel.setSales(itemModel.getSales()+amount);
        itemService.updateItem(itemModel);
        return orderModel;

    }

    /**
     * 生成订单id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected String generateOrderId(){
        //订单id 为16为数字
        StringBuilder sb = new StringBuilder();
        //前8位 年月日 20180234 代表订单生成日期
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(DateTimeFormatter.ISO_DATE).replace("-","");
        sb.append(date);

        //6位是自增序列
        SequenceInfoDO sequenceInfoDO = sequenceInfoDOMapper.getSequenceByName("order_info");
        Integer currentValue = sequenceInfoDO.getCurrentValue();
        sequenceInfoDO.setCurrentValue(currentValue+sequenceInfoDO.getStep());
        sequenceInfoDOMapper.updateByPrimaryKeySelective(sequenceInfoDO);
        String sequence = StringUtils.leftPad(String.valueOf(currentValue), 6, "0");
        sb.append(sequence);

        //最后2位是分库分表
        sb.append("00");

        return sb.toString();
    }

    private OrderInfoDO convertFromOrderModelToOrderInfoDO(OrderModel orderModel){
        if(orderModel == null){
            return null;
        }
        OrderInfoDO orderInfoDO = new OrderInfoDO();
        BeanUtils.copyProperties(orderModel, orderInfoDO);
        orderInfoDO.setItemPrice(orderModel.getOrderPrice().doubleValue());
        orderInfoDO.setItemPrice(orderModel.getItemPrice().doubleValue());
        return orderInfoDO;
    }
}
