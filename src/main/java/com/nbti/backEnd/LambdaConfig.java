package com.nbti.backEnd;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableTransactionManagement
@EnableWebMvc
public class LambdaConfig implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }

//
//	@Bean
//	@Qualifier(value = "entityManager")
//	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//		return entityManagerFactory.createEntityManager();
//	}
//
////	@Bean
////	public StudentController studentController() {
////		return new StudentController();
////	}
////
//	@Bean
//	public UserController userController() {
//		return new UserController();
//	}
//
//	@Bean
//	public UserService userService() {
//		return new UserServiceImpl();
//	}
//
//	@Bean
//	public UserRepository userRepository(EntityManager entityManager) {
//		JpaRepositoryFactory jpaRepositoryFactory = new JpaRepositoryFactory(entityManager);
//		return jpaRepositoryFactory.getRepository(UserRepository.class);
//	}

}
