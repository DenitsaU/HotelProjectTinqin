package com.example.core.converter;

import com.example.api.model.number_of_reservation.ReservationConverter;
import com.example.domain.entity.Reservation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NumberOfReservationsConverter implements Converter<Reservation, ReservationConverter> {
    @Override
    public ReservationConverter convert(Reservation source) {
        return ReservationConverter.builder()
                .reservationID(source.getReservationID())
                .hotelID(Integer.valueOf(String.valueOf(source.getHotel())))
                .days(source.getDays())
                .build();
    }
}
