package com.nbti.backEnd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nbti.backEnd.security.jwt.AuthEntryPointJwt;
import com.nbti.backEnd.security.jwt.AuthTokenFilter;
import com.nbti.backEnd.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors();
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/company", "/hosting").permitAll();

		http.httpBasic().and().authorizeRequests().antMatchers("/users/{id}", "/student/{id}", "/login")
				.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/users", "/student", "/upload")
				.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");

		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/users", "/student").hasAnyAuthority("ROLE_USER",
				"ROLE_ADMIN");

//restricting access
		http.httpBasic().and().authorizeRequests().antMatchers("/users", "/student", "/hosting", "/company")
				.hasAnyAuthority("ROLE_ADMIN");
		
		http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/api/auth/**").permitAll().antMatchers("/api/test/**").permitAll().anyRequest()
				.authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
