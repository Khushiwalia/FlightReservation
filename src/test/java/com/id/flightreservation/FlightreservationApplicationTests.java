package com.id.flightreservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.id.flightreservation.entities.Reservation;
import com.id.flightreservation.repos.ReservationRepository;
//import com.id.flightreservation.util.EmailUtil;
//import com.id.flightreservation.util.PDFGenerator;

@SpringBootTest
class FlightreservationApplicationTests {
	
//	@Autowired
//	PDFGenerator pdfGenerator;
//	
//	@Autowired
//	ReservationRepository reservationRepo;
//	
//	@Autowired
//	EmailUtil emailUtil;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testGenerateItinerary() {
//		Reservation reservation = reservationRepo.findById(1L).orElse(null);
//		String filePath	= "C:\\Users\\Kavya\\Documents\\pdf"+reservation.getId() + ".pdf";
//		pdfGenerator.generateItinerary(reservation, filePath);
//	}
	
//	@Test
//	public void testEmail() {
//		Reservation reservation = reservationRepo.findById(1L).orElse(null);
//		String filePath	= "C:\\Users\\Kavya\\Documents\\pdf"+reservation.getId() + ".pdf";
//		emailUtil.sendItinerary("kavya.verma@netprophetsglobal.com", filePath);
//	}

}
