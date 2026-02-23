package com.cdp.customer.service.impl;

import com.cdp.customer.entity.Customer;
import com.cdp.customer.entity.Portfolio;
import com.cdp.customer.exception.ResourceNotFoundException;
import com.cdp.customer.repository.CustomerRepository;
import com.cdp.customer.repository.PortfolioRepository;
import com.cdp.customer.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.cdp.customer.common.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Portfolio addPortfolio(UUID customerId, String portfolioType, String status, String riskProfile) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customerId));
        Portfolio p = Portfolio.builder()
                .portfolioId(UUID.randomUUID())
                .customer(customer)
                .portfolioType(portfolioType)
                .status(status)
                .riskProfile(riskProfile)
                .build();
        return portfolioRepository.save(p);
    }

    @Override
    public List<Portfolio> listPortfolios(UUID customerId) {
        return portfolioRepository.findByCustomerCustomerId(customerId);
    }
}
