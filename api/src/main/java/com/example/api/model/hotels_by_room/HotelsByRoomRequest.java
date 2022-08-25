package com.example.api.model.hotels_by_room;

import com.example.api.base.OperationInput;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
public class HotelsByRoomRequest implements OperationInput {
    private Integer numberOfBeds;

}
