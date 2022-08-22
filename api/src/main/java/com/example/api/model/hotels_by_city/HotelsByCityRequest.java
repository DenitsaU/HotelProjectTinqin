package com.example.api.model.hotels_by_city;

import com.example.api.base.OperationInput;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Getter
public class HotelsByCityRequest implements OperationInput {
    private String city;
}
