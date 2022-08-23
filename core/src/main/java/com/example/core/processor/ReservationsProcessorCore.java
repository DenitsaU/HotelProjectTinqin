/*package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.OperationFailed;
import com.example.api.model.number_of_reservation.NumberOfReservationsRequest;
import com.example.api.model.number_of_reservation.NumberOfReservationsResponse;
import com.example.api.operation.NumberOfReservationsProcess;
import com.example.domain.entity.Hotel;
import com.example.domain.entity.Reservation;
import com.example.domain.repository.HotelRepo;
import com.example.domain.repository.ReservationRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationsProcessorCore implements NumberOfReservationsProcess {
    private final HotelRepo hotelRepo;
    private  final ReservationRepo reservationRepo;

    public ReservationsProcessorCore(HotelRepo hotelRepo, ReservationRepo reservationRepo) {
        this.hotelRepo = hotelRepo;
        this.reservationRepo = reservationRepo;
    }


    @Override
    public Either<Error, NumberOfReservationsResponse> process(NumberOfReservationsRequest input) {
        return Try.of(() -> {
            //   final String sorted = input.getSorted();
            final List<Hotel> allHotels = hotelRepo.findAll();
            List<NumberOfReservationsResponse> sortedHotels = allHotels.stream()
                    .sorted(Comparator.comparing(Hotel::getReservations))
                    .collect(Collectors.toList());
            return NumberOfReservationsResponse.builder()
                    .allHotels(sortedHotels).build();
        }).toEither()
                .mapLeft(throwable -> {return new HotelNotFound();
                });
    }
}
*/