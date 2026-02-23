package com.cdp.customer.repository;

import com.cdp.customer.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
    List<Portfolio> findByCustomerCustomerId(UUID customerId);
}
