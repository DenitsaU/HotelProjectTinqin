package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomID;

    @ManyToOne
    @JoinColumn(name = "typeID")
    private RoomType roomType;

    @ManyToMany(mappedBy = "rooms")
    Set<Hotel> hotels;

}
