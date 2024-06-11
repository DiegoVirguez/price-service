package com.davirguezc.price.test.api.impl.infrastructure.repositories;

import com.davirguezc.price.test.api.impl.domain.model.Price;

public class PriceMapper {

    private PriceMapper() {
    }

    public static Price toDomainPrice(com.davirguezc.price.test.api.impl.infrastructure.entities.Price entityPrice) {
        return new Price(
                entityPrice.getId(),
                entityPrice.getBrandId(),
                entityPrice.getStartDate(),
                entityPrice.getEndDate(),
                entityPrice.getPriceList(),
                entityPrice.getProductId(),
                entityPrice.getPriority(),
                entityPrice.getPriceAttribute(),
                entityPrice.getCurr()
        );
    }
}