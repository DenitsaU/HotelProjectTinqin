package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.RoomNotFound;
import com.example.api.model.hotels_by_city.HotelConverter;
import com.example.api.model.hotels_by_room.HotelsByRoomRequest;
import com.example.api.model.hotels_by_room.HotelsByRoomResponse;
import com.example.api.operation.HotelsByRoomProcess;
import com.example.core.exception.RoomNotFoundException;
import com.example.domain.repository.HotelRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelsByRoomProcessorCore implements HotelsByRoomProcess {

   private final HotelRepo hotelRepo;
  //  private final RoomRepo roomRepo;
    private final ConversionService conversionService;

    public HotelsByRoomProcessorCore(HotelRepo hotelRepo/*, RoomRepo roomRepo*/, ConversionService conversionService) {
        this.hotelRepo = hotelRepo;
      //  this.roomRepo = roomRepo;
        this.conversionService = conversionService;
    }

    @Override
    public Either<Error, HotelsByRoomResponse> process(HotelsByRoomRequest input) {
        return Try.of(() -> {
                    final String numberOfBeds = String.valueOf(hotelRepo.findHotelByRoom(input.getNumberOfBeds()));
                    final List<HotelConverter> hotels = new ArrayList<>();
//                    hotelRepo.findHotelByRoom(numberOfBeds).stream()
//                            .forEach(h->{hotels.add(conversionService.convert(h,HotelConverter.class));});
                    return  HotelsByRoomResponse.builder()
                            .hotels(hotelRepo.findHotelByRoom(numberOfBeds).stream()
                            .map(h->conversionService.convert(h, HotelConverter.class))
                            .collect(Collectors.toList()))
                            .build();
                }).toEither()
                .mapLeft(throwable -> {
//                    if (throwable instanceof RoomNotFoundException) {
//                        return new RoomNotFound();
//                    }
                    return new RoomNotFound();
                });
    }
}
