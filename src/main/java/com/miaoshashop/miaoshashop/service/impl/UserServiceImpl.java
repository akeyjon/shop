package com.miaoshashop.miaoshashop.service.impl;

import com.miaoshashop.miaoshashop.common.utils.BeanConvert;
import com.miaoshashop.miaoshashop.dao.UserInfoDOMapper;
import com.miaoshashop.miaoshashop.dao.UserPasswordDOMapper;
import com.miaoshashop.miaoshashop.dataobject.UserInfoDO;
import com.miaoshashop.miaoshashop.dataobject.UserPasswordDO;
import com.miaoshashop.miaoshashop.service.UserService;
import com.miaoshashop.miaoshashop.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(int id) {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(id);
        if (userInfoDO == null) {
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userInfoDO.getId());
        return BeanConvert.convertFromDataObject(userInfoDO, userPasswordDO);
    }


    @Transactional
    @Override
    public String save(UserModel userModel) {
        UserInfoDO userInfoDO = BeanConvert.convertFromModelToUserInfoDO(userModel);
        int userId = userInfoDOMapper.insertSelective(userInfoDO);

        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setUserId(userId);
        userPasswordDO.setPassword(userModel.getEncrptPassword());

        userPasswordDOMapper.insertSelective(userPasswordDO);

        return String.valueOf(userId);

    }

    @Override
    public UserModel getUserByPhone(String phone) {
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPhone(phone);
        if(userInfoDO == null){
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userInfoDO.getId());

        UserModel userModel = BeanConvert.convertFromDataObject(userInfoDO, userPasswordDO);
        return userModel;
    }


}
