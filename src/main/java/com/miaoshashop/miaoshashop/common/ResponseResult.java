package com.miaoshashop.miaoshashop.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class ResponseResult<T> {
    @ApiModelProperty(value = "状态", name = "状态")
    private String status;

    @ApiModelProperty(value = "数据", name = "数据")
    private T data;

    public static ResponseResult ok(){
        return ok(null);
    }

    public static<T> ResponseResult ok(T data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setData(data);
        responseResult.setStatus("success");
        return responseResult;
    }

    public static <T> ResponseResult fail(T data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setData(data);
        responseResult.setStatus("fail");
        return responseResult;
    }
}
