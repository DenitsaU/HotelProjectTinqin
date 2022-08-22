package com.example.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="hotel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelID;

    private String hotelName;
    private String city;
    private Boolean freeRooms;

    @ManyToMany
    @JoinTable(
            name = "rooms_hotels",
            joinColumns = @JoinColumn(name = "hotelID"),
            inverseJoinColumns = @JoinColumn(name = "roomID"))
    Set<Room> rooms;

    @OneToMany(mappedBy = "hotel")
    private Set<Reservation> reservations;

    public Hotel(String grand_hotel, String city, boolean b) {
    }
}
