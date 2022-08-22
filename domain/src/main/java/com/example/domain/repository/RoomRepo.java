package com.example.domain.repository;

import com.example.domain.entity.Hotel;
import com.example.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
    List<Hotel> findHotelByRoom(Integer numberOfBeds);

}
