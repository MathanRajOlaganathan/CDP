package com.cdp.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "kyc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kyc {

    @Id
    @Column(name = "customer_id", nullable = false, updatable = false)
    private UUID customerId;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;

    private String kycLevel;
    private String status;
    private Instant lastVerifiedAt;
    private String remarks;
}
