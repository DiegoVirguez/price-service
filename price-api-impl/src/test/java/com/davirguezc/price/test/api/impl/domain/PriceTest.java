package com.davirguezc.price.test.api.impl.domain;

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

        Price price = new Price();
        price.setId(ID);
        price.setProductId(PRODUCT_ID);
        price.setBrandId(BRAND_ID);
        price.setPriceList(PRICE_LIST);
        price.setStartDate(startDate);
        price.setEndDate(endDate);
        price.setPriceAttribute(PRICE);
        price.setPriority(PRIORITY);
        price.setCurr(CURRENCY);

        assertEquals(ID, price.getId());
        assertEquals(PRODUCT_ID, price.getProductId());
        assertEquals(BRAND_ID, price.getBrandId());
        assertEquals(startDate, price.getStartDate());
        assertEquals(endDate, price.getEndDate());
        assertEquals(PRICE_LIST, price.getPriceList());
        assertEquals(PRICE, price.getPriceAttribute());
        assertEquals(PRIORITY, price.getPriority());
        assertEquals(CURRENCY, price.getCurr());
    }
}