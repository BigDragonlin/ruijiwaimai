package com.furuitakeout;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.furuitakeout.domain.Employee;
import com.furuitakeout.service.impl.EmployeeServiceImpl;
import com.furuitakeout.utils.AliyunSengMsg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class FuruitakeoutApplicationTests {

	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() throws SQLException {
		final Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

	@Autowired
	EmployeeServiceImpl employeeService;
	@Test
	void test01(){
		final List<Employee> list = employeeService.list(null);
		list.forEach(System.out::println);
	}

	@Test
	void test02(){
		new AliyunSengMsg().sendMsg("LTAI5tPunY9Ce6zWhbRSiZc8","5YelDsdhpIYiHcPb90p61cOawXKmOY",
				"17630827576","SMS_215331834","{code:1234}","耀动体育");
	}

	@Test
	void test04(){
		final ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
		integerThreadLocal.set(12);
		final Integer integer = integerThreadLocal.get();
		System.out.println(integer);

	}


	}


