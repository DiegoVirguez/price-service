package com.davirguezc.price.test.api.impl.domain.ports.in;

import com.davirguezc.price.test.api.impl.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GetPriceUserCase {
    Optional<Price> findApplicablePrice(LocalDateTime date, String productId, String brandId);
}
