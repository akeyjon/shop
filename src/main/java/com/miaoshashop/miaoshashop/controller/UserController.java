package com.miaoshashop.miaoshashop.controller;

import com.miaoshashop.miaoshashop.common.BaseController;
import com.miaoshashop.miaoshashop.common.ResponseResult;
import com.miaoshashop.miaoshashop.common.error.BusinessException;
import com.miaoshashop.miaoshashop.common.error.ErrorEnum;
import com.miaoshashop.miaoshashop.common.utils.BeanConvert;
import com.miaoshashop.miaoshashop.common.utils.MD5Utils;
import com.miaoshashop.miaoshashop.controller.viewobject.UserRegisterVO;
import com.miaoshashop.miaoshashop.controller.viewobject.UserVO;
import com.miaoshashop.miaoshashop.dataobject.UserInfoDO;
import com.miaoshashop.miaoshashop.service.UserService;
import com.miaoshashop.miaoshashop.service.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Random;

@RestController
@RequestMapping("/user")
@Api(tags = "用户服务")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @ApiOperation(value = "手机号登陆接口")
    @PostMapping("/phoneLogin")
    public ResponseResult phoneLogin(@RequestParam("phone") String phone, @RequestParam("password") String password){
        Assert.notNull(phone,"用户名或密码不能为空");
        Assert.notNull(password,"用户名或密码不能为空");

        UserModel userModel = userService.getUserByPhone(phone);
        String encretPassword = MD5Utils.encode(password);
        if(StringUtils.equals(userModel.getEncrptPassword(), encretPassword)){
            return ResponseResult.ok();
        }
        return ResponseResult.fail("登陆失败");
    }

    /**
     * 用户注册
     * @return
     */
    @ApiOperation(value = "用户注册接口")
    @PostMapping("/register")
    public ResponseResult register(@RequestBody @Valid UserRegisterVO userRegisterVO) throws BusinessException {
        //从seesionz中获取用户验证码
        String existOptCode = (String) httpServletRequest.getSession().getAttribute(userRegisterVO.getPhone());
        boolean flag = StringUtils.equals(existOptCode, userRegisterVO.getOtpCode());
        if(!flag){
            throw new BusinessException(ErrorEnum.OTP_CODE_ERROR);
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRegisterVO, userModel);
        //将用户明文密码转成密文
        String encode = MD5Utils.encode(userRegisterVO.getPassword());
        userModel.setEncrptPassword(encode);
        String userId = userService.save(userModel);
        return ResponseResult.ok(userId);
    }

    /**
     * 生成短信验证码
     * @param phone
     * @return
     */
    @GetMapping("/getOtp")
    @ApiOperation(value = "获取短信验证码接口")
    public ResponseResult getOtp(@RequestParam(name="phone") String phone){
        //生产短信验证码
        Random random = new Random();
        int randomInt = random.nextInt(89999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);
        //将短信验证码与对应的用户手机号绑定
        httpServletRequest.getSession().setAttribute(phone, otpCode);
        return ResponseResult.ok(otpCode);
    }

    @ApiOperation(value = "根据用户id 获取对应用户信息接口")
    @GetMapping("/{id}")
    public ResponseResult getUserById(@PathVariable("id") int id) throws BusinessException {
        UserModel userModel = userService.getUserById(id);
        UserVO userVO = BeanConvert.convertFromModel(userModel);
        if (userVO == null) {
            throw new BusinessException(ErrorEnum.USER_NOT_EXIST);
        }
        return ResponseResult.ok(userVO);
    }


}
