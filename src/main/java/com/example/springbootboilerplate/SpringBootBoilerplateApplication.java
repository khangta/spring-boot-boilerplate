package com.example.springbootboilerplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootBoilerplateApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(((SpringBootBoilerplateApplication.class)))
			.profiles("local")
			.run(args);
	}

}
