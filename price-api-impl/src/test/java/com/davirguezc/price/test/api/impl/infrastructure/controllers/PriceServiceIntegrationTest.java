package com.davirguezc.price.test.api.impl.infrastructure.controllers;

import com.davirguezc.price.test.api.impl.PriceApiImplApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = PriceApiImplApplication.class)
@AutoConfigureMockMvc
class PriceServiceIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCase1() throws Exception {
        mockMvc.perform(get("/v1/prices?applicationDate=2020-12-31T23:59:59&productId=35455&brandId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is("35455")))
                .andExpect(jsonPath("$.brandId", is("1")))
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15T16:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.finalPrice", is("38.95")));
    }

    @Test
    void testCase2() throws Exception {
        mockMvc.perform(get("/v1/prices?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is("35455")))
                .andExpect(jsonPath("$.brandId", is("1")))
                .andExpect(jsonPath("$.priceList", is(2)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T15:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-14T18:30:00")))
                .andExpect(jsonPath("$.finalPrice", is("25.45")));
    }

    @Test
    void testCase3() throws Exception {
        mockMvc.perform(get("/v1/prices?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is("35455")))
                .andExpect(jsonPath("$.brandId", is("1")))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.finalPrice", is("35.5")));
    }

    @Test
    void testCase4() throws Exception {
        mockMvc.perform(get("/v1/prices?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is("35455")))
                .andExpect(jsonPath("$.brandId", is("1")))
                .andExpect(jsonPath("$.priceList", is(3)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-15T11:00:00")))
                .andExpect(jsonPath("$.finalPrice", is("30.5")));
    }

    @Test
    void testCase5() throws Exception {
        mockMvc.perform(get("/v1/prices?applicationDate=2020-06-15T21:00:00&productId=35455&brandId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is("35455")))
                .andExpect(jsonPath("$.brandId", is("1")))
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15T16:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.finalPrice", is("38.95")));
    }

    @Test
    void testCaseNotFound() throws Exception {
        mockMvc.perform(get("/v1/prices?applicationDate=2020-06-15T21:00:00&productId=99999&brandId=1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testInvalidQueryParameters() throws Exception {
        mockMvc.perform(get("/v1/prices?applicationDate=2020-06-15T21:00:00&productId=&brandId=1"))
                .andExpect(status().isBadRequest());
    }


}