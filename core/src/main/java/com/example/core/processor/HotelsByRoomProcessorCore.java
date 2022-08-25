/*package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.RoomNotFound;
import com.example.api.model.hotels_by_city.HotelConverter;
import com.example.api.model.hotels_by_room.HotelsByRoomRequest;
import com.example.api.model.hotels_by_room.HotelsByRoomResponse;
import com.example.api.operation.HotelsByRoomProcess;
import com.example.core.exception.RoomNotFoundException;
import com.example.domain.entity.Room;
import com.example.domain.entity.RoomType;
import com.example.domain.repository.HotelRepo;
import com.example.domain.repository.RoomTypeRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelsByRoomProcessorCore implements HotelsByRoomProcess {

   private final HotelRepo hotelRepo;
   private final RoomTypeRepo roomTypeRepo;
    private final ConversionService conversionService;

    public HotelsByRoomProcessorCore(HotelRepo hotelRepo, RoomTypeRepo roomTypeRepo, ConversionService conversionService) {
        this.hotelRepo = hotelRepo;
        this.roomTypeRepo = roomTypeRepo;
        this.conversionService = conversionService;
    }

    @Override
    public Either<Error, HotelsByRoomResponse> process(HotelsByRoomRequest input) {
        return Try.of(() -> {
                   // final Integer numberOfBeds = input.getNumberOfBeds();
            final RoomType numberOfBeds = roomTypeRepo.findByNumberOfBeds(input.getNumberOfBeds()).orElseThrow(RoomNotFoundException::new);
                    final List<HotelConverter> hotels = new ArrayList<>();
final List<Room>rooms = new ArrayList<>();
final List<RoomType> roomTypes = new ArrayList<>();
                    return  HotelsByRoomResponse.builder()
                            .hotels(hotelRepo.findHotelsByRoom(numberOfBeds).stream()
                                    .filter(h->rooms.stream()
                                            .filter(r->roomTypes.stream()
                                                    .filter(roomType -> roomType.getNumberOfBeds().equals(numberOfBeds)))
                            .map(hotel->conversionService.convert(hotel, HotelConverter.class))
                            .collect(Collectors.toList())))
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
*/