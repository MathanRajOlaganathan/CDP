package com.cdp.customer.service;

import com.cdp.customer.entity.ContactDetail;

import java.util.List;
import java.util.UUID;

public interface ContactDetailService {
    ContactDetail addContact(UUID customerId, String type, String value, Boolean isPrimary);
    List<ContactDetail> listContacts(UUID customerId);
}
