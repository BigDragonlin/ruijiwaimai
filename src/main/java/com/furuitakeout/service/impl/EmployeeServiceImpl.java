package com.furuitakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furuitakeout.service.EmployeeService;
import com.furuitakeout.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【employee(员工信息)】的数据库操作Service实现
* @createDate 2022-10-22 04:11:02
*/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>
    implements EmployeeService{

}




