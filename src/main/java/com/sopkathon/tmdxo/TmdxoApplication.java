package com.sopkathon.tmdxo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TmdxoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmdxoApplication.class, args);
	}

}
