
package com.miaoshashop.miaoshashop.common.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;

    public ValidatorResult validate(Object bean){
        ValidatorResult validatorResult = new ValidatorResult();
        Set<ConstraintViolation<Object>> constrainSet= validator.validate(bean);
        if(constrainSet.size() > 0){
            validatorResult.setHasError(true);
            constrainSet.forEach(constrain ->{
                String message = constrain.getMessage();
                String propertyName = constrain.getPropertyPath().toString();
                validatorResult.getErrorMsgMap().put(propertyName,message);
            });
        }
        return  validatorResult;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        //将hibernate validator 通过工厂的初始化的方式使其实例化
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}
