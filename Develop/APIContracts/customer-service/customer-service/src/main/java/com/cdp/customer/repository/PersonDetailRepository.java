package com.cdp.customer.repository;

import com.cdp.customer.entity.PersonDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonDetailRepository extends JpaRepository<PersonDetail, UUID> {
}
