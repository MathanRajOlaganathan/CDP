package com.cdp.customer.service;

import com.cdp.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CustomerService {

    Customer createCustomer(String customerType);

    Page<Customer> listCustomers(String customerType, Pageable pageable);

    Customer getCustomer(UUID customerId);

    Customer updateCustomer(UUID customerId, Boolean isArchived);
}
