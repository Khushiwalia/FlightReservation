package com.id.flightreservation.security.config;

import java.util.ArrayList;
import java.util.List;                                                                                                                                                                                                                                                                                                
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{ 
	private final String WEB_URL="/WEB-INF/jsps/";
//	@Autowired
//	AuthenticationManager authenticationManager;
//	
//	@Autowired
//	AuthenticationConfiguration authConfig;
	
//	@Autowired
//	AuthenticationManagerBuilder auth;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
				.requestMatchers(WEB_URL+"login/registerUser.jsp",WEB_URL+"login/login.jsp",WEB_URL+"completeReservation.jsp",WEB_URL+"displayFlight.jsp",WEB_URL+"findFlights.jsp",WEB_URL+"login/reservationConfirmation.jsp", "/showReg", "/", "/index.html", "/registerUser", "/login",
						"/showLogin","/findFlights","/showCompleteReservation","/completeReservation","", "/login/*")
				.permitAll().requestMatchers("/admin/showAddFlight/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable();

		return http.build();

	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		final List<GlobalAuthenticationConfigurerAdapter> configurers = new ArrayList<>();
		configurers.add(new GlobalAuthenticationConfigurerAdapter() {
			
			public void configure(AuthenticationManagerBuilder auth) throws Exception{
				//auth.doSomething()
			}
		});
		return authConfig.getAuthenticationManager();
	}

}
