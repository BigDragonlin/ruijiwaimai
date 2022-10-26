package com.furuitakeout;

import com.furuitakeout.domain.Employee;
import com.furuitakeout.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
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
}
