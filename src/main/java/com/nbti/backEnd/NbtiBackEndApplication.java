package com.nbti.backEnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nbti.backEnd.model.ERole;
import com.nbti.backEnd.model.Role;
import com.nbti.backEnd.repositories.RoleRepository;

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

public class NbtiBackEndApplication extends SpringBootServletInitializer implements CommandLineRunner {

	 // silence console logging
//    @Value("${logging.level.root:OFF}")
    String message = "";
    @Autowired
    RoleRepository roleRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(NbtiBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepo.count()== 0) {
			roleRepo.saveAllAndFlush(List.of(
					new Role(ERole.ROLE_ADMIN),
					new Role(ERole.ROLE_MODERATOR),
					new Role(ERole.ROLE_USER)));
		}
		
	}
	
	

}
