package com.cdp.customer.service;

import com.cdp.customer.entity.Portfolio;

import java.util.List;
import java.util.UUID;

public interface PortfolioService {
    Portfolio addPortfolio(UUID customerId, String portfolioType, String status, String riskProfile);
    List<Portfolio> listPortfolios(UUID customerId);
}
