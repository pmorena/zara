package com.example.zara;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping("/search")
    public ResponseEntity<Price> getPrice(
        @RequestParam Long productId,
        @RequestParam Long brandId,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        Price price = priceService.getApplicablePrice(productId, brandId, applicationDate);
        return price != null ? ResponseEntity.ok(price) : ResponseEntity.notFound().build();
    }
}

