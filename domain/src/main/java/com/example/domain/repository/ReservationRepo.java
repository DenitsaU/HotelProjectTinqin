package com.example.domain.repository;

import com.example.domain.entity.Hotel;
import com.example.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
    public List<Reservation> getReservationsByHotel(Hotel hotel);
}
