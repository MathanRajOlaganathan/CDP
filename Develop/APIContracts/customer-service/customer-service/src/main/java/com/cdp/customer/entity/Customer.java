package com.cdp.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID customerId;

    @Column(nullable = false)
    private String customerType; // PERSON or COMPANY

    @Column(nullable = false)
    private Boolean isArchived = false;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;

    @Version
    private Integer version;
}

