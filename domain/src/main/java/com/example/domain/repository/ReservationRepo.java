package com.example.domain.repository;

import com.example.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
}
