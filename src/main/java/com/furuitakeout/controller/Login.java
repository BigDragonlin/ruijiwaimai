package com.furuitakeout.controller;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.furuitakeout.common.MyThreadLocal;
import com.furuitakeout.common.R;
import com.furuitakeout.service.impl.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@Slf4j
@Api("登录")
public class Login {

    @Autowired
    EmployeeServiceImpl employeeService;

    @ApiParam("这是获取员工的登录信息并且验证")
    @PostMapping("/employee/login")
    public R<Employee> elogin(HttpServletRequest request, @RequestBody Employee employee){
//        final long id = Thread.currentThread().getId();
//        log.info("员工登录threadid：{}",id);
//        //员工登录threadid：454

        log.info("这是获取员工的登录信息并且验证");
        log.info("employee,{}",employee.toString());
        final String password = employee.getPassword();
        final String s = SecureUtil.md5(password);
        final LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        employeeLambdaQueryWrapper.eq(Employee::getUsername,employee.getUsername()).
                eq(Employee::getPassword,s);
        final Employee one = employeeService.getOne(employeeLambdaQueryWrapper);
        log.info("one,info,{}",one);
        if (one != null){
            //        将登陆人的信息分享给其它线程
            MyThreadLocal.setCurrentId(one.getId());
            request.getSession().setAttribute("loginFlag",UUID.randomUUID());
            return R.success(one);
        }
        return R.error("请确认账号密码");
    }

    @ApiParam("登出")
    @PostMapping("/employee/logout")
    public R<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("loginFlag");
        log.info("登出成功");
        return R.success("退出成功");
    }
}
