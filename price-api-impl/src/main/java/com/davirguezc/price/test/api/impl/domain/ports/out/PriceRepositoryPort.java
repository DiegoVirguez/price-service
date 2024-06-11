package com.davirguezc.price.test.api.impl.domain.ports.out;

import com.davirguezc.price.test.api.impl.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findApplicablePrice(LocalDateTime date, String productId, String brandId);
}
