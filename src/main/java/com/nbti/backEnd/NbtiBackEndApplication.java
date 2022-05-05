package com.nbti.backEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication

@Configuration
@EnableAutoConfiguration(exclude={JacksonAutoConfiguration.class})
@ComponentScan
//@Import({
//    DispatcherServletAutoConfiguration.class,
//    ServletWebServerFactoryAutoConfiguration.class,
//    ErrorMvcAutoConfiguration.class,
//    HttpEncodingAutoConfiguration.class,
//    HttpMessageConvertersAutoConfiguration.class,
//    JacksonAutoConfiguration.class,
//    PropertyPlaceholderAutoConfiguration.class,
//    WebMvcAutoConfiguration.class,
//    SqlInitializationAutoConfiguration.class,
//    JpaRepositoriesAutoConfiguration.class,
//    DataSourceAutoConfiguration.class,
//    HibernateJpaAutoConfiguration.class,
//    JpaBaseConfiguration.class,
//    LambdaConfig.class,
//})

//@EntityScan("com.nbti.backEnd.model")

public class NbtiBackEndApplication extends SpringBootServletInitializer {

	 // silence console logging
//    @Value("${logging.level.root:OFF}")
    String message = "";
    
	public static void main(String[] args) {
		SpringApplication.run(NbtiBackEndApplication.class, args);
	}
	
	

}
