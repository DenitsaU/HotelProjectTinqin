package com.example.rest.controller;

import com.example.api.base.Error;
import com.example.api.model.hotels_by_city.HotelsByCityRequest;
import com.example.api.model.hotels_by_city.HotelsByCityResponse;
import com.example.api.model.hotels_by_room.HotelsByRoomRequest;
import com.example.api.model.hotels_by_room.HotelsByRoomResponse;
import com.example.api.operation.HotelsByCityProcess;
import com.example.api.operation.HotelsByRoomProcess;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelsByCityController {

    private final HotelsByCityProcess hotelsByCityProcess;
    //private final HotelsByRoomProcess hotelsByRoomProcess;



    public HotelsByCityController(HotelsByCityProcess hotelsByCityProcess/*, HotelsByRoomProcess hotelsByRoomProcess*/) {
        this.hotelsByCityProcess = hotelsByCityProcess;

      //  this.hotelsByRoomProcess = hotelsByRoomProcess;
    }

        @PostMapping("/hotelsByCity")
        public ResponseEntity<?> getHotelsByCity(@RequestBody HotelsByCityRequest hotelsByCityRequest){
            Either<Error, HotelsByCityResponse> response=hotelsByCityProcess.process(hotelsByCityRequest);
            if(response.isLeft()){
                return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
            }
            return ResponseEntity.status(HttpStatus.OK).body(response.get());
        }

   /* @PostMapping("/hotelsByRoom")
    public ResponseEntity<?> getHotelsByRoom(@RequestBody HotelsByRoomRequest hotelsByRoomRequest){
        Either<Error, HotelsByRoomResponse> response=hotelsByRoomProcess.process(hotelsByRoomRequest);
        if(response.isLeft()){
            return ResponseEntity.status(response.getLeft().getCode()).body(response.getLeft().getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response.get());
    }*/

}
