package com.davirguezc.price.test.api.impl.application;

import com.davirguezc.price.test.api.impl.domain.Price;
import com.davirguezc.price.test.api.impl.infrastructure.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private PriceRepository priceRepository;

    PriceService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    public Optional<Price> findApplicablePrice(LocalDateTime date, String productId, String brandId) {
        List<Price> prices = priceRepository.findPrices(date, productId, brandId);
        if (!prices.isEmpty()) {
            Price highestPriorityPrice = prices.stream()
                    .max(Comparator.comparing(Price::getPriority))
                    .orElse(null);
            return Optional.of(highestPriorityPrice);
        } else {
            return Optional.empty();
        }
    }


}
