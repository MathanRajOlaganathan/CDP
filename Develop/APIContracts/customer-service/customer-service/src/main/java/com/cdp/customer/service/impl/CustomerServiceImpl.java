package com.cdp.customer.service.impl;

import com.cdp.customer.entity.Customer;
import com.cdp.customer.exception.ResourceNotFoundException;
import com.cdp.customer.repository.CustomerRepository;
import com.cdp.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

import static com.cdp.customer.common.Constants.CUSTOMER_NOT_FOUND;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(String customerType) {
        Customer customer = Customer.builder()
                .customerId(UUID.randomUUID())
                .customerType(customerType)
                .isArchived(false)
                .createdAt(Instant.now())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> listCustomers(String customerType, Pageable pageable) {
        // Simple implementation ignoring filter for now; could add Specification/Query methods
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomer(UUID customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId)));
    }

    @Override
    public Customer updateCustomer(UUID customerId, Boolean isArchived) {
        Customer existing = getCustomer(customerId);
        if (isArchived != null) {
            existing.setIsArchived(isArchived);
        }
        existing.setUpdatedAt(Instant.now());
        return customerRepository.save(existing);
    }
}
