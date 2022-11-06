package com.furuitakeout.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.User;
import com.furuitakeout.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@Slf4j
@Api("用户登录")
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    UserServiceImpl userService;

    @ApiOperation("获取用户登录电话号码")
    @PostMapping("/user/sendMsg")
    R<String> sendMsg(@RequestBody User user){
        log.info("获取用户登录电话号码:{}",user.getPhone());
        return R.success("获取电话号码成功");
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    R<String> userLogin(@RequestBody Map map, HttpServletRequest request){
        final String phone = (String) map.get("phone");
        final String code = (String) map.get("code");
        log.info("登陆的电话是：{}，验证码是：{}",phone,code);
        if (phone.equals("17630827576")&&code.equals("1234")){
            final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getPhone,phone);
            final User one = userService.getOne(userLambdaQueryWrapper);
            if (one != null){
                request.getSession().setAttribute("userLoginSession",one.getId());
                return R.success("登录成功");
            }
            }

        return R.error("登录失败");
    }

    @ApiOperation("用户登出")
    @PostMapping("/loginout")
    R<String> userLogout(HttpServletRequest request){
        log.info("在/loginout");
        request.getSession().removeAttribute("userLoginSession");
        return R.success("登出成功");
    }
}
