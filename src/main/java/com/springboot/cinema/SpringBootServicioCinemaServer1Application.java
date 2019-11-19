package com.springboot.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootServicioCinemaServer1Application implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServicioCinemaServer1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		String passwordBcrypt = passwordEncoder.encode("12345");
		System.out.println(passwordBcrypt);
		
	}

}
