package io.playdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration

@ComponentScan({"payroll.controller", "payroll.exception", 
	"kr.pe.controller.swaggestudy.api.v1", "kr.pe.controller.swaggestudy.api.v2",
"kr.pe.khk.config"})

public class Step10SwaggerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step10SwaggerTestApplication.class, args);
	}

}
