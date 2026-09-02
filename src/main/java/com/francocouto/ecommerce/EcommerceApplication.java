package com.francocouto.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HASH DA SENHA 123456: " + new BCryptPasswordEncoder().encode("123456"));
		
	}

}
