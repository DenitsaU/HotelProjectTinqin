package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientID;

    private String clientName;
    private String clientCity;
    private String phone;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;
}
