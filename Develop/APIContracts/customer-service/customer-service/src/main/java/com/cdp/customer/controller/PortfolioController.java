package com.cdp.customer.controller;

import com.cdp.customer.entity.Portfolio;
import com.cdp.customer.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers/{customerId}/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    public record CreatePortfolioRequest(String portfolioType, String status, String riskProfile) {}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Portfolio add(@PathVariable UUID customerId, @RequestBody CreatePortfolioRequest request) {
        return portfolioService.addPortfolio(customerId, request.portfolioType(), request.status(), request.riskProfile());
    }

    @GetMapping
    public List<Portfolio> list(@PathVariable UUID customerId) {
        return portfolioService.listPortfolios(customerId);
    }
}
