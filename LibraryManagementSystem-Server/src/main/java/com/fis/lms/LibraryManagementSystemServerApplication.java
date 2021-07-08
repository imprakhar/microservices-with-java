package com.fis.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LibraryManagementSystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemServerApplication.class, args);
	}

}
