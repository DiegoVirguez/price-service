package com.davirguezc.price.test.api.impl.infrastructure;

import com.davirguezc.price.test.api.impl.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM Price p WHERE p.startDate <= :date AND p.endDate >= :date AND p.productId = :productId AND p.brandId = :brandId ORDER BY p.priority DESC")
    List<Price> findPrices(@Param("date") LocalDateTime date, @Param("productId") String productId, @Param("brandId") String brandId);
}
