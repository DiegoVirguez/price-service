package com.davirguezc.price.test.api.impl.domain.model;

import java.time.LocalDateTime;

public record Price(
        Long id,
        String brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        int priceList,
        String productId,
        int priority,
        double priceAttribute,
        String curr
) {}
