/*package com.example.rest.controller;

import com.example.api.base.Error;
import com.example.api.model.hotels_by_room.HotelsByRoomRequest;
import com.example.api.model.hotels_by_room.HotelsByRoomResponse;
import com.example.api.operation.HotelsByRoomProcess;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelsByRoomController {

    private final HotelsByRoomProcess hotelsByRoomProcess;

    public HotelsByRoomController(HotelsByRoomProcess hotelsByRoomProcess) {
        this.hotelsByRoomProcess = hotelsByRoomProcess;
    }

    @PostMapping("/hotelsByRoom")
    public ResponseEntity<?> getHotelsByRoom(@RequestBody HotelsByRoomRequest hotelsByRoomRequest){
        Either<Error, HotelsByRoomResponse> response=hotelsByRoomProcess.process(hotelsByRoomRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }
}
*/