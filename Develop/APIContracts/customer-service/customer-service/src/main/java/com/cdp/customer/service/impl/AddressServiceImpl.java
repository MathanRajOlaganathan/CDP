package com.cdp.customer.service.impl;

import com.cdp.customer.entity.Address;
import com.cdp.customer.entity.Customer;
import com.cdp.customer.exception.ResourceNotFoundException;
import com.cdp.customer.repository.AddressRepository;
import com.cdp.customer.repository.CustomerRepository;
import com.cdp.customer.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.cdp.customer.common.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Address addAddress(UUID customerId, String type, String line1, String line2, String city, String state, String country, String postalCode, Boolean isPrimary) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerId)));
        Address address = Address.builder()
                .addressId(UUID.randomUUID())
                .customer(customer)
                .type(type)
                .line1(line1)
                .line2(line2)
                .city(city)
                .state(state)
                .country(country)
                .postalCode(postalCode)
                .isPrimary(isPrimary)
                .build();
        return addressRepository.save(address);
    }

    @Override
    public List<Address> listAddresses(UUID customerId) {
        return addressRepository.findByCustomerCustomerId(customerId);
    }
}
