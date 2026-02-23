package com.cdp.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "contact_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDetail {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID contactId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;

    private String type;
    private String value;
    private Boolean isPrimary;
    private Boolean isVerified;
}
