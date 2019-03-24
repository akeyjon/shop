package com.miaoshashop.miaoshashop.controller;

import com.miaoshashop.miaoshashop.common.ResponseResult;
import com.miaoshashop.miaoshashop.controller.viewobject.ItemVO;
import com.miaoshashop.miaoshashop.service.ItemService;
import com.miaoshashop.miaoshashop.service.model.ItemModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品服务")
@RequestMapping("/item")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "根据商品id获取对应商品信息")
    @GetMapping("/{id}")
    public ResponseResult<ItemVO> getItemById(@PathVariable("id") Integer id){

        ItemVO itemVO = new ItemVO();
        ItemModel itemModel = itemService.getItemModelById(id);
        BeanUtils.copyProperties(itemModel, itemVO);
        return ResponseResult.ok(itemVO);
    }

}
