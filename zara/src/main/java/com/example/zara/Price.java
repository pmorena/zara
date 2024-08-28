package com.example.zara;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(appliesTo = "PRICES" )
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private BigDecimal price;
    private String curr;

    // Getters y Setters o usar @Data de Lombok para generarlos automáticamente
}

