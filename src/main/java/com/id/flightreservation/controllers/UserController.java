package com.id.flightreservation.controllers;

//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.id.flightreservation.entities.User;
import com.id.flightreservation.repos.UserRepository;
import com.id.flightreservation.services.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityService securityService;
	
	//private static final Logger LOGGER = org.slf4j.LoggerFactory
			//.getLogger(UserController.class);
    @Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		//LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}
	
	@RequestMapping(value="registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		//LOGGER.info("Inside register()"+user);
		user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);
		return "login/login";
	}
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		//LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password")String password,
			ModelMap modelMap) {
		boolean loginResponse = securityService.login(email, password);
		//LOGGER.info("Inside login() and the email is: "+email);
//		LOGGER.error("ERROR");
//		LOGGER.warn("WARN");
//		LOGGER.info("INFO");
//	LOGGER.debug("DEBUG");
//		LOGGER.trace("TRACE");
	
	//	User user = userRepository.findByEmail(email);
			if(loginResponse) {
				return "findFlights";
			}else {
				modelMap.addAttribute("msg", "Invalid name and password. Please try again");
			}
			
		return "login/login";
	}

}
