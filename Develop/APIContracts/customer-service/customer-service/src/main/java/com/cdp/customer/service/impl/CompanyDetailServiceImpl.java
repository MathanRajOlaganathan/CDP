package com.cdp.customer.service.impl;

import com.cdp.customer.entity.CompanyDetail;
import com.cdp.customer.entity.Customer;
import com.cdp.customer.exception.ResourceNotFoundException;
import com.cdp.customer.repository.CompanyDetailRepository;
import com.cdp.customer.repository.CustomerRepository;
import com.cdp.customer.service.CompanyDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.cdp.customer.common.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CompanyDetailServiceImpl implements CompanyDetailService {

    private final CompanyDetailRepository repository;
    private final CustomerRepository customerRepository;

    @Override
    public CompanyDetail upsertCompanyDetail(UUID customerId, CompanyDetail payload) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId)));
        CompanyDetail existing = repository.findById(customerId).orElse(null);
        if (existing == null) {
            existing = new CompanyDetail();
            existing.setCustomerId(customerId);
            existing.setCustomer(customer);
        }
        existing.setLegalName(payload.getLegalName());
        existing.setRegistrationNumber(payload.getRegistrationNumber());
        existing.setIncorporationDate(payload.getIncorporationDate());
        existing.setIndustry(payload.getIndustry());
        existing.setTaxId(payload.getTaxId());
        existing.setEmployeeCount(payload.getEmployeeCount());
        return repository.save(existing);
    }

    @Override
    public Optional<CompanyDetail> getCompanyDetail(UUID customerId) {
        return repository.findById(customerId);
    }
}
