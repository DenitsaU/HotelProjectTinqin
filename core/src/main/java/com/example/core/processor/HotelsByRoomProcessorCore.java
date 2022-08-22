package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.RoomNotFound;
import com.example.api.model.hotels_by_room.HotelsByRoomRequest;
import com.example.api.model.hotels_by_room.HotelsByRoomResponse;
import com.example.api.operation.HotelsByRoomProcess;
import com.example.domain.entity.Hotel;
import com.example.domain.entity.RoomType;
import com.example.domain.repository.RoomRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelsByRoomProcessorCore implements HotelsByRoomProcess {

//    private final HotelRepo hotelRepo;
//
//    public HotelsByRoomProcessorCore(HotelRepo hotelRepo) {
//        this.hotelRepo = hotelRepo;
//    }

    private final RoomRepo roomRepo;

    public HotelsByRoomProcessorCore(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public Either<Error, HotelsByRoomResponse> process(HotelsByRoomRequest input) {
        return Try.of(() -> {
                    final List<Hotel> hotel = roomRepo.findHotelByRoom(input.getNumberOfBeds());
                    return  HotelsByRoomResponse.builder()
                            .hotelName("Panorama hotel")
                            .build();
                }).toEither()
                .mapLeft(throwable -> {
//                    if (throwable instanceof NoSuchElementException) {
//                        return new RoomNotFound();
//                    }
                    return new RoomNotFound();
                });
    }
}
