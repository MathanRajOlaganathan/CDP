package com.cdp.customer.service;

import com.cdp.customer.entity.PersonDetail;

import java.util.Optional;
import java.util.UUID;

public interface PersonDetailService {
    PersonDetail upsertPersonDetail(UUID customerId, PersonDetail payload);
    Optional<PersonDetail> getPersonDetail(UUID customerId);
}
