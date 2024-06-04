package com.davirguezc.price.test.api.impl.application;

import com.davirguezc.price.test.api.impl.domain.Price;
import com.davirguezc.price.test.api.impl.domain.ports.in.GetPriceUserCase;
import com.davirguezc.price.test.api.impl.domain.ports.out.PriceRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService implements GetPriceUserCase {

    private PriceRepositoryPort priceRepositoryPort;

    public PriceService(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime date, String productId, String brandId) {
        return priceRepositoryPort.findApplicablePrice(date, productId, brandId);
    }


}
