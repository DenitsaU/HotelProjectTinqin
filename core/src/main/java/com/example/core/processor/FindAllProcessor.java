/*package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.CityNotFound;
import com.example.api.model.hotels_by_city.HotelsByCityRequest;
import com.example.api.model.hotels_by_city.HotelsByCityResponse;
import com.example.api.operation.HotelsByCityProcess;
import com.example.domain.entity.Hotel;
import com.example.domain.repository.HotelRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FindAllProcessor implements HotelsByCityProcess {

    private final HotelRepo hotelRepo;

    public FindAllProcessor(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Either<Error, HotelsByCityResponse> process(HotelsByCityRequest input) {
        return Try.of(() -> {
            final List<Hotel> hotels = hotelRepo.findHotelsByCity(input.getCity());
            return hotelRepo.findAll().stream()
                    .map(h ->{
   Hotel.builder()
        .hotelName("Grand hotel").city("Varna").build();
                      return  HotelsByCityResponse.builder(hotels).build();
                    })
                    .collect(Collectors.toList());
           // return HotelsByCityResponse.builder(hotels).build();
                           // h.getHotelName())


        })
                .toEither()
                .mapLeft(throwable ->{
        return new CityNotFound();
    });
    }
}
*/