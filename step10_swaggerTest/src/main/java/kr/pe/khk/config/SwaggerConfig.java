package kr.pe.khk.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//Employee
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//    @Bean
//    public Docket swaggerApi() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("payroll.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .useDefaultResponseMessages(false); // 기본으로 세팅되는 200,401,403,404 메시지를 표시 하지 않음
//    }
//
//    private ApiInfo swaggerInfo() {
//        return new ApiInfoBuilder().title("Employee API Documentation")
//                .description("Test 관련 부연 설명")
//                .license("khk").licenseUrl("http://www.google.com").version("2").build();
//    }
//}


//controller v1와 v2의 문서 구성
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private String version;
    private String title;
    
    @Bean  
    public Docket apiV1() {
        version = "V1";  
        title = "Swagger Project API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kr.pe.controller.swaggestudy.api.v1"))
                .paths(PathSelectors.ant("/v1/api/**"))
                .build()
                .apiInfo(apiInfo(title, version));
  
    }

    @Bean  
    public Docket apiV2() {
        version = "V2";
        title = "victolee API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kr.pe.controller.swaggestudy.api.v2"))
                .paths(PathSelectors.ant("/v2/api/**"))
                .build()
                .apiInfo(apiInfo(title, version));

    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title, "<b>Swagger로 생성한 API Docs</b>", 
                version, "www.example.com",
                new Contact("Contact Me", "http://www.apache.org/licenses/LICENSE-2.0.html", "foo@example.com"),
                "Find out more about Swagger", "https://swagger.io/", new ArrayList<>());
    }
}