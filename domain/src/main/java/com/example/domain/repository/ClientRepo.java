package com.example.domain.repository;

import com.example.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Integer> {
}
