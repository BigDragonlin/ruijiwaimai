package com.furuitakeout;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"com.furuitakeout.mapper"})
@EnableTransactionManagement
@EnableAsync(proxyTargetClass = true)
public class FuruitakeoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuruitakeoutApplication.class, args);
	}

}
