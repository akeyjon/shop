package com.miaoshashop.miaoshashop.common.error;

public interface Error {
    public int getErrCode();
    public String getErrMessage();
    public Error setErrMessage(String errMessage);
}
