package com.cdp.customer.service.impl;

import com.cdp.customer.entity.Customer;
import com.cdp.customer.entity.Kyc;
import com.cdp.customer.exception.ResourceNotFoundException;
import com.cdp.customer.repository.CustomerRepository;
import com.cdp.customer.repository.KycRepository;
import com.cdp.customer.service.KycService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.cdp.customer.common.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class KycServiceImpl implements KycService {

    private final KycRepository repository;
    private final CustomerRepository customerRepository;

    @Override
    public Kyc upsertKyc(UUID customerId, Kyc payload) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customerId));
        Kyc existing = repository.findById(customerId).orElse(null);
        if (existing == null) {
            existing = new Kyc();
            existing.setCustomerId(customerId);
            existing.setCustomer(customer);
        }
        existing.setKycLevel(payload.getKycLevel());
        existing.setStatus(payload.getStatus());
        existing.setLastVerifiedAt(payload.getLastVerifiedAt());
        existing.setRemarks(payload.getRemarks());
        return repository.save(existing);
    }

    @Override
    public Optional<Kyc> getKyc(UUID customerId) {
        return repository.findById(customerId);
    }
}
