package com.miaoshashop.miaoshashop.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

    //private int id;

    private String name;

    private Byte gender;

    private int age;

    private String phone;

    private String registerModle;

    private String thirdPartyId;

    private String encrptPassword;

}


