package com.davirguezc.price.test.api.impl.rest;

import com.davirguezc.price.test.api.v1.model.PriceDetail;
import com.davirguezc.price.test.api.v1.rest.PriceApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PriceController implements PriceApi {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public ResponseEntity<PriceDetail> v1PricesGet(@RequestParam Date applicationDate, @RequestParam  String productId, @RequestParam String brandId) {

        return null;
    }
}
