package com.jincreation.JShop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jincreation.JShop.dao")
public class JShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JShopApplication.class, args);
	}

}
