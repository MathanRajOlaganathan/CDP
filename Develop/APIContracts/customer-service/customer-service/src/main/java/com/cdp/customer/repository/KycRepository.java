package com.cdp.customer.repository;

import com.cdp.customer.entity.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KycRepository extends JpaRepository<Kyc, UUID> {
}
