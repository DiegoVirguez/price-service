package com.davirguezc.price.test.api.impl.infrastructure.controllers;

import com.davirguezc.price.test.api.impl.domain.exception.PriceBadRequestException;
import com.davirguezc.price.test.api.impl.domain.exception.PriceNotFoundException;
import com.davirguezc.price.test.api.impl.domain.model.Price;
import com.davirguezc.price.test.api.impl.domain.ports.in.GetPriceUserCase;
import com.davirguezc.price.test.api.v1.model.PriceDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class PriceControllerTest {

    private static final String PRODUCT_ID = "testProductId";
    private static final String BRAND_ID = "testBrandId";
    public static final String EMPTY_STRING = "";


    @Mock
    private GetPriceUserCase priceService;

    @InjectMocks
    private PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPrice_whenPriceExists() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = PRODUCT_ID;
        String brandId = BRAND_ID;

        Price price = new Price(1L, brandId, applicationDate, applicationDate.plusDays(1), 1, productId, 1, 100.0, "EUR");

        when(priceService.findApplicablePrice(applicationDate, productId, brandId)).thenReturn(Optional.of(price));

        ResponseEntity<PriceDetail> response = priceController.getPrice(applicationDate, productId, brandId);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(productId, response.getBody().getProductId());
        assertEquals(brandId, response.getBody().getBrandId());
    }

    @Test
    void getPrice_whenPriceDoesNotExist() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = PRODUCT_ID;
        String brandId = BRAND_ID;

        when(priceService.findApplicablePrice(applicationDate, productId, brandId)).thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class, () -> priceController.getPrice(applicationDate, productId, brandId));
    }

    @Test
    void getPrice_whenInvalidQueryParameters() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = EMPTY_STRING;
        String brandId = EMPTY_STRING;

        assertThrows(PriceBadRequestException.class, () -> priceController.getPrice(applicationDate, productId, brandId));
    }
    @Test
    void getPrice_whenProductIdIsEmpty() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = EMPTY_STRING;
        String brandId = BRAND_ID;

        assertThrows(PriceBadRequestException.class, () -> priceController.getPrice(applicationDate, productId, brandId));
    }

    @Test
    void getPrice_whenBrandIdIsEmpty() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = PRODUCT_ID;
        String brandId = EMPTY_STRING;

        assertThrows(PriceBadRequestException.class, () -> priceController.getPrice(applicationDate, productId, brandId));
    }
}