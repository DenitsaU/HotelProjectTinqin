package com.example.api.model.hotels_by_city;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
public class HotelConverter {
    private String hotelName;
    private String city;
    private Boolean freeRooms;
  //  private Integer numberOfBeds;
}
