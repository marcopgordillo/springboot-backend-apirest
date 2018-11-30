package com.example.springbootbackendapirest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableCaching
public class SpringbootBackendApirestApplication implements CommandLineRunner {

  private final BCryptPasswordEncoder passwordEncoder;

  public SpringbootBackendApirestApplication(BCryptPasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApirestApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {

    String password = "12345";

    for (int i = 0; i < 4; i++) {
      String passwordBcrypt = passwordEncoder.encode(password);
      System.out.println(passwordBcrypt);
    }
  }
}
