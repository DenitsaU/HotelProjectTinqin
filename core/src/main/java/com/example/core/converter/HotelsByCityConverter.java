package com.example.core.converter;

import com.example.api.model.hotels_by_city.HotelConverter;
import com.example.domain.entity.Hotel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HotelsByCityConverter implements Converter<Hotel, HotelConverter> {

    @Override
    public HotelConverter convert(Hotel source) {
        return HotelConverter.builder()
                .hotelName(source.getHotelName())
                .city(source.getCity())
                .freeRooms(source.getFreeRooms())
                .build();
    }
}
