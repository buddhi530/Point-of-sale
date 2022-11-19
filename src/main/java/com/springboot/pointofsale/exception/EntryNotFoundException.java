package com.springbootacademy.pointofsale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class EntryNotFoundException extends RuntimeException {
    public EntryNotFoundException(String message){
        super(message);
    }
}
