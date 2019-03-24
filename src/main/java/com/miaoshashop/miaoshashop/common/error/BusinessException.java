package com.miaoshashop.miaoshashop.common.error;

// 包装器模式
public class BusinessException extends Exception implements Error {

    private Error errorCode;

    public BusinessException(Error errorCode){
        super();
        this.errorCode = errorCode;
    }

    // 接收自定义异常信息
    public BusinessException(Error errorCode, String msg){
        super();
        this.errorCode = errorCode;
        this.setErrMessage(msg);
    }
    @Override
    public int getErrCode() {
        return this.errorCode.getErrCode();
    }

    @Override
    public String getErrMessage() {
        return this.errorCode.getErrMessage();
    }

    @Override
    public Error setErrMessage(String errMessage) {
        this.errorCode.setErrMessage(errMessage);
        return this;
    }
}
