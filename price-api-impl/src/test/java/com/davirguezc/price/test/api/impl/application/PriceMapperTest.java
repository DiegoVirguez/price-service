package com.davirguezc.price.test.api.impl.application;

import com.davirguezc.price.test.api.impl.infrastructure.controllers.PriceMapper;
import com.davirguezc.price.test.api.impl.domain.model.Price;
import com.davirguezc.price.test.api.v1.model.PriceDetail;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceMapperTest {

    @Test
    void testMapToPriceDetail() {

        LocalDateTime now = LocalDateTime.now();
        Price price = new Price(1L, "testBrandId", now, now.plusDays(1), 1, "testProductId", 1, 100.0, "EUR");

        PriceDetail priceDetail = PriceMapper.mapToPriceDetail(price);

        assertEquals(price.productId(), priceDetail.getProductId());
        assertEquals(price.brandId(), priceDetail.getBrandId());
        assertEquals(price.priceList(), priceDetail.getPriceList());
        assertEquals(price.startDate(), priceDetail.getStartDate());
        assertEquals(price.endDate(), priceDetail.getEndDate());
        assertEquals(BigDecimal.valueOf(price.priceAttribute()), priceDetail.getFinalPrice());
    }
}