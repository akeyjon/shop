package com.miaoshashop.miaoshashop.common.utils;

import com.miaoshashop.miaoshashop.controller.viewobject.UserVO;
import com.miaoshashop.miaoshashop.dataobject.UserInfoDO;
import com.miaoshashop.miaoshashop.dataobject.UserPasswordDO;
import com.miaoshashop.miaoshashop.service.model.UserModel;
import org.springframework.beans.BeanUtils;

public class BeanConvert {
    public static UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

    public static UserModel convertFromDataObject(UserInfoDO userInfoDO, UserPasswordDO userPasswordDO){
        if(userInfoDO == null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userInfoDO, userModel);
        if(userPasswordDO == null){
            return userModel;
        }
        userModel.setEncrptPassword(userPasswordDO.getPassword());
        return userModel;
    }

    public static UserInfoDO convertFromModelToUserInfoDO(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        BeanUtils.copyProperties(userModel, userInfoDO);
        return userInfoDO;
    }




}
