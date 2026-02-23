package com.cdp.customer.controller;

import com.cdp.customer.entity.Customer;
import com.cdp.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request.customerType());
    }

    @GetMapping
    public java.util.List<Customer> listCustomers(@RequestParam(required = false) String customerType,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return customerService.listCustomers(customerType, PageRequest.of(page, size)).getContent();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable UUID customerId) {
        return customerService.getCustomer(customerId);
    }

    @PatchMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable UUID customerId, @RequestBody UpdateCustomerRequest request) {
        return customerService.updateCustomer(customerId, request.isArchived());
    }

    public record CreateCustomerRequest(String customerType) {}
    public record UpdateCustomerRequest(Boolean isArchived) {}
}
