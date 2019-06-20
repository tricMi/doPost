package com.example.postDo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.postDo.service"})
public class PostDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostDoApplication.class, args);
	}

}
