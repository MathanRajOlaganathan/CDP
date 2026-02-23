package com.cdp.customer.controller;

import com.cdp.customer.entity.Kyc;
import com.cdp.customer.service.KycService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers/{customerId}/kyc")
@RequiredArgsConstructor
public class KycController {

    private final KycService service;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Kyc upsert(@PathVariable UUID customerId, @RequestBody Kyc request) {
        return service.upsertKyc(customerId, request);
    }

    @GetMapping
    public Kyc get(@PathVariable UUID customerId) {
        return service.getKyc(customerId)
                .orElseThrow(() -> new com.cdp.customer.exception.ResourceNotFoundException(String.format(com.cdp.customer.common.Constants.KYC_NOT_FOUND, customerId)));
    }
}
