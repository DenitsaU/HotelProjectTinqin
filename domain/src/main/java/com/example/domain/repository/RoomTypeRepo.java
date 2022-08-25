package com.example.domain.repository;

import com.example.domain.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomTypeRepo extends JpaRepository<RoomType,Integer> {
    Optional<RoomType> findByNumberOfBeds(Integer numberOfBeds);
}
