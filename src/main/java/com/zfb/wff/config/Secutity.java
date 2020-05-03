package com.zfb.wff.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Secutity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		
//		http.authorizeRequests()
//			.antMatchers("/index").permitAll()
//			.antMatchers("/user", "/user/*").hasRole("admin")
//			.anyRequest().authenticated()
//			.and()
//			.formLogin().defaultSuccessUrl("/user").failureUrl("/error")
//			.and()
//			.httpBasic();	
			 
			// @formatter:on

	}
}
