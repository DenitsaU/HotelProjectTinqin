package com.example.domain.repository;

import com.example.domain.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {
    List<Hotel> findHotelsByCity(String city);
 //   List<Hotel> findHotelByRoom(String numberOfBeds);

    public List<Hotel> findAll();


}
