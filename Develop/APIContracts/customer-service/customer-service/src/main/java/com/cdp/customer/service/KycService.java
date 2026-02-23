package com.cdp.customer.service;

import com.cdp.customer.entity.Kyc;

import java.util.Optional;
import java.util.UUID;

public interface KycService {
    Kyc upsertKyc(UUID customerId, Kyc payload);
    Optional<Kyc> getKyc(UUID customerId);
}
