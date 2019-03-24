package com.miaoshashop.miaoshashop.controller.viewobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@ApiModel
public class UserRegisterVO implements Serializable {

    private static final long serialVersionUID = 6971445893989027598L;

    //姓名
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(name = "姓名", required = true)
    private String name;

    //性别
    @ApiModelProperty(name = "性别")
    private Byte gender;

    //年龄
    private int age;

    //电话
    @NotBlank(message = "电话不能为空")
    private String phone;

    //
    private String registerModle;

    //三方来源
    private String thirdPartyId;

    //明文密码
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,10}$",
            message = "强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 8-10 之间)")
    private String password;

    //验证码
    private String otpCode;
}
