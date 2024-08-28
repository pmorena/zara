package com.example.zara;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId AND :applicationDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
    List<Price> findApplicablePrices(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applicationDate") LocalDateTime applicationDate);
}

