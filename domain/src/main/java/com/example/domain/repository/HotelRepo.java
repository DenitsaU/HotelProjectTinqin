package com.example.domain.repository;

import com.example.domain.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {
    List<Hotel> findHotelsByCity(String city);
//    Optional<Hotel> findHotelByRoom(Integer numberOfBeds);

    public List<Hotel> findAll();


}
