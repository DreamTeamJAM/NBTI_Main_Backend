package com.nbti.backEnd;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.nbti.backEnd.controllers.UserController;

@Configuration
@Import(UserController.class)
public class LambdaConfig {

//	@Bean
//    public StudentController studentController() {
//         return new StudentController();
//    }
//	
//	@Bean
//    public UserController userController() {
//         return new UserController();
//    }
//	
//	public UserService userService() {
//		return new UserServiceImpl();
//	}
	
	
    
   
}
