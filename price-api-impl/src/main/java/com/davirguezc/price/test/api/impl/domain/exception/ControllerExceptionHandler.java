package com.davirguezc.price.test.api.impl.domain.exception;

import com.davirguezc.price.test.api.v1.model.InlineResponse400;
import com.davirguezc.price.test.api.v1.model.InlineResponse404;
import com.davirguezc.price.test.api.v1.model.InlineResponse500;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<InlineResponse404> handlePriceNotFoundException(PriceNotFoundException e) {
        InlineResponse404 response404 = new InlineResponse404();
        response404.setErrorCode("404");
        String errorMessage = String.format("Resource not found: %s", e.getMessage());
        response404.setErrorMessage(errorMessage);
        return new ResponseEntity<>(response404, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PriceBadRequestException.class)
    public ResponseEntity<InlineResponse400> handleIllegalArgumentException(PriceBadRequestException e) {
        InlineResponse400 response400 = new InlineResponse400();
        response400.setErrorCode("400");
        String errorMessage = String.format("Invalid query parameters: %s", e.getMessage());
        response400.setError(errorMessage);
        return new ResponseEntity<>(response400, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PriceInternalServerErrorException.class)
    public ResponseEntity<InlineResponse500> handleException(PriceInternalServerErrorException e) {
        InlineResponse500 response500 = new InlineResponse500();
        response500.setErrorCode("500");
        String errorMessage = String.format("Internal Server Error: %s", e.getMessage());
        response500.setErrorMessage(errorMessage);
        return new ResponseEntity<>(response500, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
