package com.id.flightreservation.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.id.flightreservation.controllers.ReservationController;
import com.id.flightreservation.dto.ReservationRequest;
import com.id.flightreservation.entities.Flight;
import com.id.flightreservation.entities.Passenger;
import com.id.flightreservation.entities.Reservation;
import com.id.flightreservation.repos.FlightRepository;
import com.id.flightreservation.repos.PassengerRepository;
import com.id.flightreservation.repos.ReservationRepository;
//import com.id.flightreservation.util.EmailUtil;
//import com.id.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.id.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	//@Autowired
	//PDFGenerator pdfGenerator;
	
	//@Autowired
	//EmailUtil emailUtil;
//	
//	private static final Logger LOGGER = org.slf4j.LoggerFactory
//			.getLogger(ReservationServiceImpl .class);
//	
// 
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		
		//LOGGER.info("Inside bookFlight()");
		//Make Payment
		
		Long flightId = request.getFlightId();
		//LOGGER.info("Fetching flight for flight id:" + flightId );
		Flight flight = flightRepository.findById(flightId).orElse(null);
		
		Passenger passenger = new Passenger();
		passenger.setFirstname(request.getPassengerFirstName());
		passenger.setLastname(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		//LOGGER.info("Saving the passenger:" + passenger);
		Passenger savedPassenger=passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		//LOGGER.info("Saving the reservation()" + reservation);
		Reservation savedReservation =  reservationRepository.save(reservation);
		
//		String filePath	= ITINERARY_DIR+savedReservation.getId() + ".pdf";
//		//LOGGER.info("Generationg the itinerary");
		//pdfGenerator.generateItinerary(savedReservation, filePath);
		//LOGGER.info("Emailing the itinerary");
		//emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return savedReservation;
	}

}
