package com.example.core_module.service;

import java.util.List;

import com.example.core_module.dto.ContactDto;
import com.example.core_module.model.Contact;

public interface ContactService {
List<Contact> findAll();
Contact findById(Long contact_id);
void deleteById(Long contact_id);
Contact save(ContactDto contactDto,String email);
}
