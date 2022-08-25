package com.example.api.model.hotels_by_city;

import com.example.api.base.OperationResult;
//import com.example.domain.entity.Hotel;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class HotelsByCityResponse implements OperationResult {
public List<HotelConverter> hotels;
   // private String hotelName;
}
