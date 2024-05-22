package com.davirguezc.price.test.api.impl.domain.exception;

import com.davirguezc.price.test.api.v1.model.BadRequestResponse;
import com.davirguezc.price.test.api.v1.model.InternalServerErrorResponse;
import com.davirguezc.price.test.api.v1.model.NotFoundResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerExceptionHandlerTest {

    private final ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler();

    @Test
    void handlePriceNotFoundException() {
        PriceNotFoundException exception = new PriceNotFoundException("Resource not found");
        ResponseEntity<NotFoundResponse> response = controllerExceptionHandler.handlePriceNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("404", response.getBody().getErrorCode());
        assertEquals("Resource not found", response.getBody().getErrorMessage());
    }

    @Test
    void handleIllegalArgumentException() {
        PriceBadRequestException exception = new PriceBadRequestException("Invalid query parameters");
        ResponseEntity<BadRequestResponse> response = controllerExceptionHandler.handleIllegalArgumentException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("400", response.getBody().getErrorCode());
        assertEquals("Invalid query parameters", response.getBody().getError());
    }

    @Test
    void handleException() {
        PriceInternalServerErrorException exception = new PriceInternalServerErrorException("Internal Server Error");
        ResponseEntity<InternalServerErrorResponse> response = controllerExceptionHandler.handleException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("500", response.getBody().getErrorCode());
        assertEquals("Internal Server Error", response.getBody().getErrorMessage());
    }
}