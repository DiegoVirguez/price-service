package com.davirguezc.price.test.api.impl.infrastructure.controllers;

import com.davirguezc.price.test.api.impl.domain.exception.PriceBadRequestException;
import com.davirguezc.price.test.api.impl.domain.exception.PriceNotFoundException;
import com.davirguezc.price.test.api.impl.domain.model.Price;
import com.davirguezc.price.test.api.impl.domain.ports.in.GetPriceUserCase;
import com.davirguezc.price.test.api.v1.model.PriceDetail;
import com.davirguezc.price.test.api.v1.rest.PriceApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PriceController implements PriceApi {

    private GetPriceUserCase priceService;

    public PriceController(GetPriceUserCase priceService) {
        this.priceService = priceService;
    }

    @Override
    public ResponseEntity<PriceDetail> getPrice(@RequestParam LocalDateTime applicationDate, @RequestParam String productId, @RequestParam String brandId) {
        if (productId.isEmpty()) {
            throw new PriceBadRequestException("Invalid query parameter: productId is empty");
        }
        if (brandId.isEmpty()) {
            throw new PriceBadRequestException("Invalid query parameter: brandId is empty");
        }
            Price applicablePrice = priceService.findApplicablePrice(applicationDate, productId, brandId)
                    .orElseThrow(() -> new PriceNotFoundException("Resource not found for productId: " + productId + " and brandId: " + brandId));
            PriceDetail priceDetail = PriceMapper.mapToPriceDetail(applicablePrice);
            return new ResponseEntity<>(priceDetail, HttpStatus.OK);
    }

}