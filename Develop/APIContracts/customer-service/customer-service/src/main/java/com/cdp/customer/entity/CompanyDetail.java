package com.cdp.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "company_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDetail {

    @Id
    @Column(name = "customer_id", nullable = false, updatable = false)
    private UUID customerId;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;

    private String legalName;
    private String registrationNumber;
    private LocalDate incorporationDate;
    private String industry;
    private String taxId;
    private Integer employeeCount;
}
