package com.davirguezc.price.test.api.impl.interfaces;

import com.davirguezc.price.test.api.impl.application.PriceMapper;
import com.davirguezc.price.test.api.impl.application.PriceService;
import com.davirguezc.price.test.api.impl.domain.Price;
import com.davirguezc.price.test.api.impl.domain.exception.PriceBadRequestException;
import com.davirguezc.price.test.api.impl.domain.exception.PriceNotFoundException;
import com.davirguezc.price.test.api.v1.model.PriceDetail;
import com.davirguezc.price.test.api.v1.rest.PriceApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController implements PriceApi {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public ResponseEntity<PriceDetail> getPrice(@RequestParam LocalDateTime applicationDate, @RequestParam String productId, @RequestParam String brandId) {
        if (productId.isEmpty() || brandId.isEmpty()) {
            throw new PriceBadRequestException("Invalid query parameters");
        }
            Price applicablePrice = priceService.findApplicablePrice(applicationDate, productId, brandId)
                    .orElseThrow(() -> new PriceNotFoundException("Resource not found"));
            PriceDetail priceDetail = PriceMapper.mapToPriceDetail(applicablePrice);
            return new ResponseEntity<>(priceDetail, HttpStatus.OK);
    }

}