package com.example.GestionDeBus.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeBus.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
