package com.example.api.error;

import com.example.api.base.Error;
import org.springframework.http.HttpStatus;

public class CityNotFound implements Error {

    @Override
    public HttpStatus getCode() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return "City not found";
    }
}
