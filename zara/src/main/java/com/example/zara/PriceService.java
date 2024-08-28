package com.example.zara;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public Price getApplicablePrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<Price> prices = (List<Price>) priceRepository.findApplicablePrices(productId, brandId, applicationDate);
        return prices.isEmpty() ? null : prices.get(0);
    }
}

