package com.furuitakeout;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.furuitakeout.mapper"})
public class FuruitakeoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuruitakeoutApplication.class, args);
	}

}
