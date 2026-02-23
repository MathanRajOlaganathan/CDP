package com.cdp.customer.controller;

import com.cdp.customer.entity.Address;
import com.cdp.customer.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.lang.String;

@RestController
@RequestMapping("/customers/{customerId}/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    public record CreateAddressRequest(String type, String line1, String line2, String city, String state, String country, String postalCode, Boolean isPrimary){}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address add(@PathVariable UUID customerId, @RequestBody CreateAddressRequest request) {
        return service.addAddress(customerId, request.type(), request.line1(), request.line2(), request.city(), request.state(), request.country(), request.postalCode(), request.isPrimary());
    }

    @GetMapping
    public List<Address> list(@PathVariable UUID customerId) {
        return service.listAddresses(customerId);
    }
}
