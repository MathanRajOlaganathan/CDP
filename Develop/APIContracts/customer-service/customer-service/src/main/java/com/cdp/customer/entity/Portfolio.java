package com.cdp.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "portfolio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID portfolioId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;

    private String portfolioType;
    private String status;
    private String riskProfile;
}
