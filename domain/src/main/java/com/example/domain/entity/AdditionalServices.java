package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="additionalServices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdditionalServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceID;
    private String serviceName;
}
