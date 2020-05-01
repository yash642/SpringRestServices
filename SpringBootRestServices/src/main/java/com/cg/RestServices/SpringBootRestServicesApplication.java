package com.cg.RestServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringBootRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServicesApplication.class, args);
	}
	
	@Profile("dev")
	@Bean
	public String devDbConnection() {
        System.out.println("DB for Dev - Inmemory H2");
        return "DB for Dev - Inmemory";
    }
	
	@Profile("prod")
	@Bean
	 public String prodDbConnection() {
	        System.out.println("DB for Prod - High Performance MySql");
	        return "DB for Prod - High Performance MySql";
	 }

}
