package com.example.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="reservation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationID;
    private LocalDate date;
    private Integer days;

    @ManyToOne
    @JoinColumn(name = "hotelID", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "clientID", nullable = false)
    private Client client;

}
