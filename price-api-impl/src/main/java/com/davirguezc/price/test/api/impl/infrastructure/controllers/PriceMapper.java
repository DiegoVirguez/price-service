package com.davirguezc.price.test.api.impl.infrastructure.controllers;

import com.davirguezc.price.test.api.impl.domain.model.Price;
import com.davirguezc.price.test.api.v1.model.PriceDetail;

import java.math.BigDecimal;


public class PriceMapper {

    private PriceMapper() {}

    public static PriceDetail mapToPriceDetail(Price price) {
        PriceDetail priceDetail = new PriceDetail();

        priceDetail.setProductId(price.productId());
        priceDetail.setBrandId(price.brandId());
        priceDetail.setPriceList(price.priceList());
        priceDetail.setStartDate(price.startDate());
        priceDetail.setEndDate(price.endDate());
        priceDetail.setFinalPrice(BigDecimal.valueOf(price.priceAttribute()));

        return priceDetail;
    }
}