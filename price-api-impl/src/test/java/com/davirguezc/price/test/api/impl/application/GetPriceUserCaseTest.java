package com.davirguezc.price.test.api.impl.application;

import com.davirguezc.price.test.api.impl.domain.Price;
import com.davirguezc.price.test.api.impl.domain.ports.out.PriceRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class GetPriceUserCaseTest {

    private static final String PRODUCT_ID = "testProductId";
    private static final String BRAND_ID = "testBrandId";

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private PriceService getPriceUserCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findApplicablePrice_whenPriceExists() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = PRODUCT_ID;
        String brandId = BRAND_ID;

        Price price = new Price();
        price.setProductId(productId);
        price.setBrandId(brandId);
        price.setPriceAttribute(100.0);
        price.setPriority(1);

        when(priceRepositoryPort.findApplicablePrice(applicationDate, productId, brandId)).thenReturn(Optional.of(price));

        Optional<Price> response = getPriceUserCase.findApplicablePrice(applicationDate, productId, brandId);

        assertTrue(response.isPresent());
        assertEquals(price, response.get());
    }

    @Test
    void findApplicablePrice_whenPriceDoesNotExist() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = PRODUCT_ID;
        String brandId = BRAND_ID;

        when(priceRepositoryPort.findApplicablePrice(applicationDate, productId, brandId)).thenReturn(Optional.empty());

        Optional<Price> response = getPriceUserCase.findApplicablePrice(applicationDate, productId, brandId);

        assertTrue(response.isEmpty());
    }
}