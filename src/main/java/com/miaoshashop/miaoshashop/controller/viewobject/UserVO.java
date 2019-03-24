package com.miaoshashop.miaoshashop.controller.viewobject;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserVO implements Serializable {

    private static final long serialVersionUID = -503706725933451320L;

    private int id;

    private String name;

    private Byte gender;

    private int age;

    private String phone;



}
