package com.example.api.model.number_of_reservation;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
public class ReservationConverter {
    private Integer reservationID;
    private Integer hotelID;
private Integer days;
}
