package com.example.api.model.number_of_reservation;

import com.example.api.base.OperationResult;
import com.example.api.model.hotels_by_city.HotelConverter;
import com.example.api.model.hotels_by_city.HotelsByCityResponse;
//import com.example.domain.entity.Hotel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class NumberOfReservationsResponse implements OperationResult {
   //private Integer numberOfReservations;
    private List<ReservationConverter>reservations;
}
