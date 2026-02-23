package com.cdp.customer.service;

import com.cdp.customer.entity.Address;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    Address addAddress(UUID customerId, String type, String line1, String line2, String city, String state, String country, String postalCode, Boolean isPrimary);
    List<Address> listAddresses(UUID customerId);
}
