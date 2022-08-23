package com.example.core.processor;

import com.example.api.base.Error;
import com.example.api.error.CityNotFound;
import com.example.api.model.hotels_by_city.HotelConverter;
import com.example.api.model.hotels_by_city.HotelsByCityRequest;
import com.example.api.model.hotels_by_city.HotelsByCityResponse;
import com.example.api.operation.HotelsByCityProcess;
//import com.example.domain.entity.Hotel;
import com.example.core.exception.CityNotFoundException;
import com.example.domain.entity.Hotel;
import com.example.domain.repository.HotelRepo;
//import com.example.domain.repository.RoomRepo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelsByCityProcessorCore implements HotelsByCityProcess {
private final HotelRepo hotelRepo;
private final ConversionService conversionService;

    public HotelsByCityProcessorCore(HotelRepo hotelRepo, ConversionService conversionService) {
        this.hotelRepo = hotelRepo;

        this.conversionService = conversionService;
    }

    @Override
    public Either<Error, HotelsByCityResponse> process(final HotelsByCityRequest input) {
        return Try.of(() -> {
//final List<Hotel> hotel = hotelRepo.findHotelsByCity(input.getCity());
                    final String city = String.valueOf(hotelRepo.findHotelsByCity(input.getCity()));
                    final List<HotelConverter> hotels = new ArrayList<>();
//                     hotelRepo.findHotelsByCity(city).stream()
//                    .forEach(h->{hotels.add(conversionService.convert(h,HotelConverter.class));});
                    return HotelsByCityResponse.builder()
                            .hotels(hotelRepo.findHotelsByCity(city).stream()
                                    .map(h->conversionService.convert(h, HotelConverter.class))
                                    .collect(Collectors.toList()))
                            //.hotels(hotels)
                            .build();
                }).toEither()
                .mapLeft(throwable -> {
//                    if (throwable instanceof CityNotFoundException) {
//                        return new CityNotFound();
//                    }
                    return new CityNotFound();
                });

    }
}
