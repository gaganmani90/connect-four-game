package com.droptoken.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidGameException extends Exception{
    public InvalidGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGameException(String message) {
        super(message);
    }
}
