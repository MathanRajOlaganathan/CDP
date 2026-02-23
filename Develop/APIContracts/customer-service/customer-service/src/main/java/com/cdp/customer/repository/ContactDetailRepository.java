package com.cdp.customer.repository;

import com.cdp.customer.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetail, UUID> {
    List<ContactDetail> findByCustomerCustomerId(UUID customerId);
}
