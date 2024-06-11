package com.davirguezc.price.test.api.impl.infrastructure.repositories;

import com.davirguezc.price.test.api.impl.domain.model.Price;
import com.davirguezc.price.test.api.impl.domain.ports.out.PriceRepositoryPort;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {
    private final PriceRepository priceRepository;

    public PriceRepositoryAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime date, String productId, String brandId) {
        return priceRepository.findPrices(date, productId, brandId)
                .map(PriceMapper::toDomainPrice);
    }
}
