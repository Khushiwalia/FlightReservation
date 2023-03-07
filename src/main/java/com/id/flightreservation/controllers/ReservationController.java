package com.id.flightreservation.controllers;

//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.id.flightreservation.dto.ReservationRequest;
import com.id.flightreservation.entities.Flight;
import com.id.flightreservation.entities.Reservation;
import com.id.flightreservation.repos.FlightRepository;
import com.id.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	//private static final Logger LOGGER = org.slf4j.LoggerFactory
			//.getLogger(ReservationRestController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		//LOGGER.info("showCompleteReservation() invoked with the flight Id:" +flightId );
		Flight flight = flightRepository.findById(flightId).orElse(null);
		modelMap.addAttribute("flight",flight);
		//LOGGER.info("Flight is:" + flight);
		return "completeReservation";
		
	}
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		//LOGGER.info("completeReservation()" + request );
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Reservation Created successfully and the id is"+ reservation.getId());
		return "login/reservationConfirmation";
	}

}
