package com.davirguezc.price.test.api.impl.domain;

import com.davirguezc.price.test.api.impl.domain.model.Price;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTest {

    private static final Long ID = 1L;
    private static final String BRAND_ID = "testBrandId";
    private static final String PRODUCT_ID = "testProductId";
    private static final int PRICE_LIST = 1;
    private static final double PRICE = 100.0;
    private static final int PRIORITY = 1;
    private static final int PLUS_DAY = 1;
    private static final String CURRENCY = "eur";
    private LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime endDate = LocalDateTime.now().plusDays(PLUS_DAY);

    @Test
    void testGettersAndSetters() {

        Price price = new Price(ID, BRAND_ID, startDate, endDate, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY);

        assertEquals(ID, price.id());
        assertEquals(PRODUCT_ID, price.productId());
        assertEquals(BRAND_ID, price.brandId());
        assertEquals(startDate, price.startDate());
        assertEquals(endDate, price.endDate());
        assertEquals(PRICE_LIST, price.priceList());
        assertEquals(PRICE, price.priceAttribute());
        assertEquals(PRIORITY, price.priority());
        assertEquals(CURRENCY, price.curr());
    }
}