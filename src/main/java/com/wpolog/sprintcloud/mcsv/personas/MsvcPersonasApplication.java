package com.wpolog.sprintcloud.mcsv.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvcPersonasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcPersonasApplication.class, args);
	}

}
