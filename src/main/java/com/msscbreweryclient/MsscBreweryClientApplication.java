package com.msscbreweryclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class MsscBreweryClientApplication {

	public static void main(String[] args) {
		log.info("Microservice Brewery Initialized {}", " Author : Maroti Pawar");
		SpringApplication.run(MsscBreweryClientApplication.class, args);
	}

}
