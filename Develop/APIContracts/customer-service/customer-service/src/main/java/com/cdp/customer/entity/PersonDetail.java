package com.cdp.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "person_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDetail {

    @Id
    @Column(name = "customer_id", nullable = false, updatable = false)
    private UUID customerId;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Customer customer;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationalId;
    private String gender;
    private String citizenship;
}
