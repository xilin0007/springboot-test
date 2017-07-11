package com.fxl.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring Boot启动入口
 * Created by cent on 2016/9/2.
 */
@EnableWebMvc
//@Configuration
@SpringBootApplication(scanBasePackages = {"com.fxl"})
@ServletComponentScan(basePackages = {"com.fxl.configuration"})
public class Application extends WebMvcConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    /*@Bean  
    public ServletRegistrationBean servletRegistrationBean() {  
        return new ServletRegistrationBean(new DruidStatViewServlet(), "/druid/*");// ServletName默认值为首字母小写，即myServlet  
    }*/
}
