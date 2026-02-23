package com.cdp.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID addressId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;

    private String type;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private Boolean isPrimary;
}
