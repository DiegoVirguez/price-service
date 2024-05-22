package com.davirguezc.price.test.api.impl.application;

import com.davirguezc.price.test.api.impl.domain.Price;
import com.davirguezc.price.test.api.impl.infrastructure.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    private static final String PRODUCT_ID = "testProductId";
    private static final String BRAND_ID = "testBrandId";

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findApplicablePrice_whenPriceExists() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = PRODUCT_ID;
        String brandId = BRAND_ID;

        Price price1 = new Price();
        price1.setProductId(productId);
        price1.setBrandId(brandId);
        price1.setPriceAttribute(100.0);
        price1.setPriority(1);

        Price price2 = new Price();
        price2.setProductId(productId);
        price2.setBrandId(brandId);
        price2.setPriceAttribute(200.0);
        price2.setPriority(2);

        List<Price> prices = Arrays.asList(price1, price2);

        when(priceRepository.findPrices(applicationDate, productId, brandId)).thenReturn(prices);

        Optional<Price> response = priceService.findApplicablePrice(applicationDate, productId, brandId);

        assertTrue(response.isPresent());
        assertEquals(price2, response.get());
    }

    @Test
    void findApplicablePrice_whenPriceDoesNotExist() {
        LocalDateTime applicationDate = LocalDateTime.now();
        String productId = PRODUCT_ID;
        String brandId = BRAND_ID;

        when(priceRepository.findPrices(applicationDate, productId, brandId)).thenReturn(Arrays.asList());

        Optional<Price> response = priceService.findApplicablePrice(applicationDate, productId, brandId);

        assertTrue(response.isEmpty());
    }
}