package com.davirguezc.price.test.api.impl.application;

import com.davirguezc.price.test.api.impl.domain.Price;
import com.davirguezc.price.test.api.v1.model.PriceDetail;

import java.math.BigDecimal;


public class PriceMapper {

    private PriceMapper() {}

    public static PriceDetail mapToPriceDetail(Price price) {
        PriceDetail priceDetail = new PriceDetail();

        priceDetail.setProductId(price.getProductId());
        priceDetail.setBrandId(price.getBrandId());
        priceDetail.setPriceList(price.getPriceList());
        priceDetail.setStartDate(price.getStartDate());
        priceDetail.setEndDate(price.getEndDate());
        priceDetail.setFinalPrice(BigDecimal.valueOf(price.getPriceAttribute()));

        return priceDetail;
    }
}