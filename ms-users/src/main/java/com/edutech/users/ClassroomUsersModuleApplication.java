package com.edutech.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.edutech.users.client")
@SpringBootApplication
@ComponentScan(basePackages = {"com.edutech.users", "com.edutech.users.mapper"})
public class ClassroomUsersModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassroomUsersModuleApplication.class, args);
	}

}
