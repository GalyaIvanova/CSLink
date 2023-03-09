package com.example.project._recactor.model.data.exceptions;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomResourceNotFoundException extends ResourceNotFoundException {
    public CustomResourceNotFoundException(String message, Long id) {
        super(message, id.toString());
    }
    public CustomResourceNotFoundException(String message) {
        super(message);
    }
}
