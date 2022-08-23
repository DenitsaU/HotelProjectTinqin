package com.example.api.model.hotels_by_room;

import com.example.api.base.OperationResult;
import com.example.api.model.hotels_by_city.HotelConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HotelsByRoomResponse implements OperationResult {
    private List<HotelConverter> hotels;
   // private String hotelName;
}
