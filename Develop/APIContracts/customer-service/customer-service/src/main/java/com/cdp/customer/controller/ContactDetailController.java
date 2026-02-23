package com.cdp.customer.controller;

import com.cdp.customer.entity.ContactDetail;
import com.cdp.customer.service.ContactDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers/{customerId}/contacts")
@RequiredArgsConstructor
public class ContactDetailController {

    private final ContactDetailService service;

    public record CreateContactRequest(String type, String value, Boolean isPrimary) {}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDetail add(@PathVariable UUID customerId, @RequestBody CreateContactRequest request) {
        return service.addContact(customerId, request.type(), request.value(), request.isPrimary());
    }

    @GetMapping
    public List<ContactDetail> list(@PathVariable UUID customerId) {
        return service.listContacts(customerId);
    }
}
