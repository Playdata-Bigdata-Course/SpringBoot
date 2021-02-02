package io.playdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("io.playdata.controller")
@EnableJpaRepositories(basePackages="io.playdata.dao")
@EntityScan("io.playdata.model.domain")
public class Step07BootSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step07BootSpringDataJpaApplication.class, args);
	}

}
