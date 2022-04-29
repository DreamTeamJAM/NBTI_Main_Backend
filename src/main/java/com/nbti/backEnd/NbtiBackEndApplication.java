package com.nbti.backEnd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.nbti.backEnd.controllers.UserController;

@SpringBootApplication
public class NbtiBackEndApplication extends SpringBootServletInitializer {

	 // silence console logging
    @Value("${logging.level.root:OFF}")
    String message = "";
    
	public static void main(String[] args) {
		SpringApplication.run(NbtiBackEndApplication.class, args);
	}
	
	

}
