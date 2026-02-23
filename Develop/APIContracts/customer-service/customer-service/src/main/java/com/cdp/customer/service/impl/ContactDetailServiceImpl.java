package com.cdp.customer.service.impl;

import com.cdp.customer.entity.ContactDetail;
import com.cdp.customer.entity.Customer;
import com.cdp.customer.exception.ResourceNotFoundException;
import com.cdp.customer.repository.ContactDetailRepository;
import com.cdp.customer.repository.CustomerRepository;
import com.cdp.customer.service.ContactDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.cdp.customer.common.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ContactDetailServiceImpl implements ContactDetailService {

    private final ContactDetailRepository repository;
    private final CustomerRepository customerRepository;

    @Override
    public ContactDetail addContact(UUID customerId, String type, String value, Boolean isPrimary) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customerId));
        ContactDetail contact = ContactDetail.builder()
                .contactId(UUID.randomUUID())
                .customer(customer)
                .type(type)
                .value(value)
                .isPrimary(isPrimary)
                .isVerified(false)
                .build();
        return repository.save(contact);
    }

    @Override
    public List<ContactDetail> listContacts(UUID customerId) {
        return repository.findByCustomerCustomerId(customerId);
    }
}
