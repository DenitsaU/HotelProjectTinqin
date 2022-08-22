package com.example.domain.repository;

import com.example.domain.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepo extends JpaRepository<RoomType,Integer> {
}
