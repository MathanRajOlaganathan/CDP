package com.cdp.customer.controller;

import com.cdp.customer.entity.CompanyDetail;
import com.cdp.customer.service.CompanyDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers/{customerId}/company")
@RequiredArgsConstructor
public class CompanyDetailController {

    private final CompanyDetailService service;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CompanyDetail upsert(@PathVariable UUID customerId, @RequestBody CompanyDetail request) {
        return service.upsertCompanyDetail(customerId, request);
    }

    @GetMapping
    public CompanyDetail get(@PathVariable UUID customerId) {
        return service.getCompanyDetail(customerId)
                .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
