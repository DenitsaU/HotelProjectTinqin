package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.HotelNotFound;
import com.example.api.error.OperationFailed;
import com.example.api.model.number_of_reservation.NumberOfReservationsRequest;
import com.example.api.model.number_of_reservation.NumberOfReservationsResponse;
import com.example.api.model.number_of_reservation.ReservationConverter;
import com.example.api.operation.NumberOfReservationsProcess;
import com.example.core.exception.HotelNotFoundException;
import com.example.domain.entity.Hotel;
import com.example.domain.repository.HotelRepo;
import com.example.domain.repository.ReservationRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationsProcessorCore implements NumberOfReservationsProcess {
    private final HotelRepo hotelRepo;
    private  final ReservationRepo reservationRepo;
    private final ConversionService conversionService;

    public ReservationsProcessorCore(HotelRepo hotelRepo, ReservationRepo reservationRepo, ConversionService conversionService) {
        this.hotelRepo = hotelRepo;
        this.reservationRepo = reservationRepo;
        this.conversionService = conversionService;
    }


    @Override
    public Either<Error, NumberOfReservationsResponse> process(NumberOfReservationsRequest input) {
        return Try.of(() -> {
            final Hotel hotelID = hotelRepo.findById(input.getHotelID()).orElseThrow(HotelNotFoundException::new);
                 //   final List<ReservationConverter> reservations = new ArrayList<>();

            return NumberOfReservationsResponse.builder()
                    .reservations(reservationRepo.getReservationsByHotel(hotelID).stream()
                           /// .filter(r->r.getHotel().equals(hotelID)))
                            .map(r->conversionService.convert(r, ReservationConverter.class))
                            .collect(Collectors.toList()))
                  //  .numberOfReservations(reservationRepo.getReservationsByHotel(hotelID))
                    .build();

                }).toEither()
                .mapLeft(throwable -> {
                    if (throwable instanceof HotelNotFoundException) {
                        return new HotelNotFound();
                    }
                    return new OperationFailed();
                });
    }
}
