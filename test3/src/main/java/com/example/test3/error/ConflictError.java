package com.example.test3.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictError extends RuntimeException {

    public ConflictError(String message) {
        super(message);
    }
}
