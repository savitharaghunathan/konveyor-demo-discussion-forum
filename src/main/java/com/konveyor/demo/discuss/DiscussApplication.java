package com.konveyor.demo.discuss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DiscussApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscussApplication.class, args);
	}

}
