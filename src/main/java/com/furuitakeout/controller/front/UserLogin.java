package com.furuitakeout.controller.front;

import com.furuitakeout.common.R;
import com.furuitakeout.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api("用户登录")
public class UserLogin {

    @ApiOperation("获取用户登录电话号码")
    @PostMapping("/user/sendMsg")
    R<String> sendMsg(@RequestBody User user){
        log.info("获取用户登录电话号码:{}",user.getPhone());
        return R.success("获取电话号码成功");
    }
}
