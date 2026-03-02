package com.example.HocNao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HocNaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HocNaoApplication.class, args);
	}

}
