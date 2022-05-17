package com.nbti.backEnd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	NBTIUserDetailsService mongoUserDetailsService;

	@Autowired
	CustomAuthSuccessHandler customAuthSuccessHandler;

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// disabling Cross-Site Request Forgery
		http.csrf().disable();
		
		http.cors();
		// no authentication required
		http.authorizeRequests().antMatchers("/logout", "/signUp").permitAll();

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/company", "/hosting").permitAll();

		// authenticated users
//		http.authorizeRequests().antMatchers("/adminHome", "/userHome").authenticated();

		http.httpBasic().and().authorizeRequests().antMatchers("/users/{id}", "/student/{id}", "/login")
				.hasAnyAuthority("student", "admin").and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler());

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/users", "/student", "/upload")
				.hasAnyAuthority("student", "admin").and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler());

		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/users", "/student").hasAnyAuthority("student", "admin")
				.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler());
		// restricting access
		http.httpBasic().and().authorizeRequests().antMatchers("/users", "/student", "/hosting", "/company")
				.hasAnyAuthority("admin").and().exceptionHandling().accessDeniedHandler(accessDeniedHandler());

		// configure login form
		http.authorizeRequests().and().formLogin().loginPage("/login").successHandler(customAuthSuccessHandler)
				.failureUrl("/login?failed").usernameParameter("username").passwordParameter("password")

				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(mongoUserDetailsService);
	}
}
