package com.miaoshashop.miaoshashop.common.error;

public enum ErrorEnum implements Error {
    //100000 开头为通用错误类型
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    SYSTEM_ERROR(10002,"系统错误"),
    //20000开头为用户信息相关错误
    USER_NOT_EXIST(20001,"用户不存在"),
    OTP_CODE_ERROR(20002,"用户验证码错误"),


    ;

    private int errCode;
    private String errMessage;

    ErrorEnum(int errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMessage() {
        return this.errMessage;
    }

    @Override
    public Error setErrMessage(String errMessage) {
        this.errMessage = errMessage;
        return this;
    }
}
