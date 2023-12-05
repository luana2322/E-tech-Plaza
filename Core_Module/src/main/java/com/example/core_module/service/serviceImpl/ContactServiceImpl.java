package com.example.core_module.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.core_module.dto.ContactDto;
import com.example.core_module.model.Contact;
import com.example.core_module.repository.ContactRepository;
import com.example.core_module.repository.CustomerRepository;
import com.example.core_module.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
@Autowired
private ContactRepository contactRepository;
@Autowired
private CustomerRepository customerRepository;
	@Override
	public List<Contact> findAll() {
		List<Contact> list=contactRepository.findAll();
		return  list;
	}

	@Override
	public Contact findById(Long contact_id) {
		Contact contact=contactRepository.findById(contact_id).get();
		return contact;
	}

	@Override
	public void deleteById(Long contact_id) {
		contactRepository.deleteById(contact_id);
	}

	@Override
	public Contact save(ContactDto contactDto,String email) {
		Contact contact=new Contact();
		contact.setName(contactDto.getName());
		contact.setEmail(contactDto.getEmail());
		contact.setSubject(contactDto.getSubject());
		contact.setMessage(contactDto.getMessage());
		contact.setCustomer(customerRepository.findBycustomeremail(email).get());
		return contactRepository.save(contact);
	}

}
