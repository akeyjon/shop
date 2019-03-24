package com.miaoshashop.miaoshashop.common.validator;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ValidatorResult {

    private boolean hasError = false;

    //存放错误信息
    private Map<String, String> errorMsgMap = new HashMap<>();

    //格式化输出错误信息
    public String getErrMsg(){
       return StringUtils.join(errorMsgMap.values().toArray(),",");
    }
}
