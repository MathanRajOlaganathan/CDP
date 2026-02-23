package com.cdp.customer.repository;

import com.cdp.customer.entity.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyDetailRepository extends JpaRepository<CompanyDetail, UUID> {
}
