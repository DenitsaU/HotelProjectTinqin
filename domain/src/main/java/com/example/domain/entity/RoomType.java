package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="roomType")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeID;

    private Double price;
    private Integer numberOfBeds;

    @OneToMany(mappedBy = "roomType")
    private Set<Room> rooms;

}
