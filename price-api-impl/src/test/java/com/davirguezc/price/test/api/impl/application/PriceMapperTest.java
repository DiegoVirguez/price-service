package com.davirguezc.price.test.api.impl.application;

import com.davirguezc.price.test.api.impl.domain.Price;
import com.davirguezc.price.test.api.v1.model.PriceDetail;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceMapperTest {

    @Test
    void testMapToPriceDetail() {

        Price price = new Price();
        price.setProductId("testProductId");
        price.setBrandId("testBrandId");
        price.setPriceList(1);
        price.setStartDate(LocalDateTime.now());
        price.setEndDate(LocalDateTime.now().plusDays(1));
        price.setPriceAttribute(100.0);

        PriceDetail priceDetail = PriceMapper.mapToPriceDetail(price);

        assertEquals(price.getProductId(), priceDetail.getProductId());
        assertEquals(price.getBrandId(), priceDetail.getBrandId());
        assertEquals(price.getPriceList(), priceDetail.getPriceList());
        assertEquals(price.getStartDate(), priceDetail.getStartDate());
        assertEquals(price.getEndDate(), priceDetail.getEndDate());
        assertEquals(BigDecimal.valueOf(price.getPriceAttribute()), priceDetail.getFinalPrice());
    }
}