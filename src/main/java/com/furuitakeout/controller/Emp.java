package com.furuitakeout.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.furuitakeout.common.MyThreadLocal;
import com.furuitakeout.common.R;
import com.furuitakeout.domain.Employee;
import com.furuitakeout.service.impl.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@Api("员工处理")
public class Emp {

    @Autowired
    EmployeeServiceImpl employeeService;

    @ApiParam("添加员工")
    @RequestMapping("/employee")
    @ResponseBody
    public R<String> addEmployee(@RequestBody Employee employee){
        log.info("要添加的员工信息==》{}",employee.toString());
        final boolean save = employeeService.save(employee);
        log.info("员工添加{}",save);
        return save?R.success("添加成功"):R.error("添加失败");
    }

    @ApiParam("获取员工列表")
    @GetMapping("/employee/page")
    @ResponseBody
    public R<Page> showEmp(int page,int pageSize,String name){
        log.info("in showEmp MyThreadLocal.getCurrentId()==>{}",MyThreadLocal.getCurrentId());

        final Page pageInfo = new Page(page,pageSize);
        log.info("第几页：{}，有多少：{}",page,pageSize);
        final LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();

        employeeLambdaQueryWrapper.like((!StringUtils.isEmpty(name)),Employee::getName,name);
        employeeLambdaQueryWrapper.orderByAsc(Employee::getCreate_time);
        employeeService.page(pageInfo, employeeLambdaQueryWrapper);
        log.info("pageInfo==>{}",pageInfo.toString());

        return R.success(pageInfo);
    }

    @ApiParam("启用，禁用员工")
    @PutMapping("/employee")
    @ResponseBody
    public R<String> empSwitch(@RequestBody Employee employee){
        log.info("启用,禁用员工信息==》{}",employee.toString());
        employeeService.updateById(employee);
        return R.success("启用，禁用成功");
    }

    @ApiParam("修改员工")
    @GetMapping("/employee/{id}")
    @ResponseBody
    public R<Employee> updateEmp(@PathVariable Integer id){
        log.info("修改员工id：{}",id);
        final LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getId,id);
        final Employee employee = employeeService.getOne(wrapper);
        log.info("查出来的员工值：{}",employee);
        return R.success(employee);
    }

}
