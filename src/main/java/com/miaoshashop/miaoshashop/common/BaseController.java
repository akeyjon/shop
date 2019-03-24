package com.miaoshashop.miaoshashop.common;

import com.miaoshashop.miaoshashop.common.error.BusinessException;
import com.miaoshashop.miaoshashop.common.error.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseResult handlException(HttpServletRequest request, Exception ex){
        log.error(ex.getMessage(),ex);
        Map<String, Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMessage", businessException.getErrMessage());
            return ResponseResult.fail(responseData);

        }else {
//            BusinessException businessException = new BusinessException(ErrorEnum.SYSTEM_ERROR);
//            responseData.put("errCode", businessException.getErrCode());
//            responseData.put("errMessage", businessException.getErrMessage());
            return ResponseResult.fail(ex.getMessage());
        }
    }
}
