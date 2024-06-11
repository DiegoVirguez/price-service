package com.davirguezc.price.test.api.impl.infrastructure.repositories;

import com.davirguezc.price.test.api.impl.infrastructure.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query(value = "SELECT * FROM Price p WHERE p.start_date <= :date AND p.end_date >= :date AND p.product_id = :productId AND p.brand_id = :brandId ORDER BY p.priority DESC LIMIT 1", nativeQuery = true)
    Optional<Price> findPrices(@Param("date") LocalDateTime date, @Param("productId") String productId, @Param("brandId") String brandId);
}
