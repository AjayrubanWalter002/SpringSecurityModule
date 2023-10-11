package com.security.securitycheck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class UserAuth extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Ajay")
		.password("12345")
		.roles("Alluser");
	}

	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/user")
		.permitAll()
		.and()
		.formLogin();
		http.authorizeHttpRequests()
		.antMatchers("/Admin").authenticated()
		.and()
		.formLogin();

	}

}
