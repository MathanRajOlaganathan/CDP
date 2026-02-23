package com.cdp.customer.service.impl;

import com.cdp.customer.entity.Customer;
import com.cdp.customer.entity.PersonDetail;
import com.cdp.customer.exception.ResourceNotFoundException;
import com.cdp.customer.repository.CustomerRepository;
import com.cdp.customer.repository.PersonDetailRepository;
import com.cdp.customer.service.PersonDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.cdp.customer.common.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PersonDetailServiceImpl implements PersonDetailService {

    private final PersonDetailRepository repository;
    private final CustomerRepository customerRepository;

    @Override
    public PersonDetail upsertPersonDetail(UUID customerId, PersonDetail payload) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId)));
        PersonDetail existing = repository.findById(customerId).orElse(null);
        if (existing == null) {
            existing = new PersonDetail();
            existing.setCustomerId(customerId);
            existing.setCustomer(customer);
        }
        existing.setFirstName(payload.getFirstName());
        existing.setLastName(payload.getLastName());
        existing.setDateOfBirth(payload.getDateOfBirth());
        existing.setNationalId(payload.getNationalId());
        existing.setGender(payload.getGender());
        existing.setCitizenship(payload.getCitizenship());
        return repository.save(existing);
    }

    @Override
    public Optional<PersonDetail> getPersonDetail(UUID customerId) {
        return repository.findById(customerId);
    }
}
