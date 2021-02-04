package kr.pe.khk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration

@ComponentScan({"kr.pe.controller.swaggestudy.api.v1", "kr.pe.controller.swaggestudy.api.v2","kr.pe.khk.config"})
public class Step23SwaggerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step23SwaggerTestApplication.class, args);
	}

}
