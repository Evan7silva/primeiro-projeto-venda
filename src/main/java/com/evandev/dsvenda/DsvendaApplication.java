package com.evandev.dsvenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.evandev.dsvenda.model")
public class DsvendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsvendaApplication.class, args);
	}

}
