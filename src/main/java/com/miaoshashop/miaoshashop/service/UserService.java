package com.miaoshashop.miaoshashop.service;

import com.miaoshashop.miaoshashop.dataobject.UserInfoDO;
import com.miaoshashop.miaoshashop.service.model.UserModel;

public interface UserService {

    /**
     *根据用户id 获取用户信息
     * @param id
     * @return
     */
    UserModel getUserById(int id);


    /**
     *新增保存用户信息
     * @param userModel
     */
    String save(UserModel userModel);

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    UserModel getUserByPhone(String phone);


}
