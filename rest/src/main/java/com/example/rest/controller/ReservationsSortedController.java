package com.example.rest.controller;

import com.example.api.base.Error;
import com.example.api.model.number_of_reservation.NumberOfReservationsRequest;
import com.example.api.model.number_of_reservation.NumberOfReservationsResponse;
import com.example.api.operation.NumberOfReservationsProcess;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationsSortedController {
    private  final NumberOfReservationsProcess numberOfReservationsProcess;

    public ReservationsSortedController(NumberOfReservationsProcess numberOfReservationsProcess) {
        this.numberOfReservationsProcess = numberOfReservationsProcess;
    }

    @PostMapping("/sortedHotelsByReservations")
    public ResponseEntity<?> sortHotelsByReservations(@RequestBody final NumberOfReservationsRequest numberOfReservationsRequest) {
        Either<Error, NumberOfReservationsResponse> response = numberOfReservationsProcess.process(numberOfReservationsRequest);
        if (response.isLeft()) {
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }
}
