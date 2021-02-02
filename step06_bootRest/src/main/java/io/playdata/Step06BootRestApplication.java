package io.playdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"io.playdata.controller"})
public class Step06BootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step06BootRestApplication.class, args);
	}

}
