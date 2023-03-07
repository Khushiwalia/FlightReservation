package com.id.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.id.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
