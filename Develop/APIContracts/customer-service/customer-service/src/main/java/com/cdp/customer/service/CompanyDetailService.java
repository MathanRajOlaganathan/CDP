package com.cdp.customer.service;

import com.cdp.customer.entity.CompanyDetail;

import java.util.Optional;
import java.util.UUID;

public interface CompanyDetailService {
    CompanyDetail upsertCompanyDetail(UUID customerId, CompanyDetail payload);
    Optional<CompanyDetail> getCompanyDetail(UUID customerId);
}
