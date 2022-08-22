package com.example.api.model.hotels_by_room;

import com.example.api.base.OperationResult;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HotelsByRoomResponse implements OperationResult {
    //private List<Hotel>hotels;
    private String hotelName;
}
