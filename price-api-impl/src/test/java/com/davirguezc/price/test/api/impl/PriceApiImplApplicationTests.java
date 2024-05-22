package com.davirguezc.price.test.api.impl;

import com.davirguezc.price.test.api.impl.application.PriceService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriceApiImplApplicationTests {

    @Autowired
    private PriceService priceService;

    @Test
    void contextLoads() {
        assertNotNull(priceService, "The service should not be null");
    }

}