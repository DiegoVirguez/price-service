package com.davirguezc.price.test.api.impl.domain.exception;

import com.davirguezc.price.test.api.v1.model.BadRequestResponse;
import com.davirguezc.price.test.api.v1.model.NotFoundResponse;
import com.davirguezc.price.test.api.v1.model.InternalServerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<NotFoundResponse> handlePriceNotFoundException(PriceNotFoundException e) {
        NotFoundResponse response404 = new NotFoundResponse();
        response404.setErrorCode("404");
        String errorMessage = String.format(e.getMessage());
        response404.setErrorMessage(errorMessage);
        return new ResponseEntity<>(response404, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PriceBadRequestException.class)
    public ResponseEntity<BadRequestResponse> handleIllegalArgumentException(PriceBadRequestException e) {
        BadRequestResponse response400 = new BadRequestResponse();
        response400.setErrorCode("400");
        String errorMessage = String.format(e.getMessage());
        response400.setError(errorMessage);
        return new ResponseEntity<>(response400, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PriceInternalServerErrorException.class)
    public ResponseEntity<InternalServerErrorResponse> handleException(PriceInternalServerErrorException e) {
        InternalServerErrorResponse response500 = new InternalServerErrorResponse();
        response500.setErrorCode("500");
        String errorMessage = String.format(e.getMessage());
        response500.setErrorMessage(errorMessage);
        return new ResponseEntity<>(response500, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
