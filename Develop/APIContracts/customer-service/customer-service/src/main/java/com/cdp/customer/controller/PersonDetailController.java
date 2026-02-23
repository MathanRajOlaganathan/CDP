package com.cdp.customer.controller;

import com.cdp.customer.entity.PersonDetail;
import com.cdp.customer.service.PersonDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers/{customerId}/person")
@RequiredArgsConstructor
public class PersonDetailController {

    private final PersonDetailService service;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonDetail upsert(@PathVariable UUID customerId, @RequestBody PersonDetail request) {
        return service.upsertPersonDetail(customerId, request);
    }

    @GetMapping
    public PersonDetail get(@PathVariable UUID customerId) {
        return service.getPersonDetail(customerId)
                .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
