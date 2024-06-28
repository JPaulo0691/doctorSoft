package com.br.doctorsoft.customExceptions.exceptionHandler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GeneralErrorResponse {

    private HttpStatus httpStatus;
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public GeneralErrorResponse(HttpStatus status, String message, String details){
        this.httpStatus = status;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
}
