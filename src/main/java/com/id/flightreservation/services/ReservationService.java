package com.id.flightreservation.services;

import com.id.flightreservation.dto.ReservationRequest;
import com.id.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
		

}
