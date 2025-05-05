package com.minhadose.demo.service;

import com.minhadose.demo.model.ContactModel;
import com.minhadose.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<ContactModel> getAllContacts() {
        return contactRepository.findAll();
    }

    public ContactModel getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public ContactModel createContact(ContactModel contact) {
        return contactRepository.save(contact);
    }

    public ContactModel updateContact(Long id, ContactModel contact) {
        ContactModel existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact != null) {
            existingContact.setCountryCode(contact.getCountryCode());
            existingContact.setStateCode(contact.getStateCode());
            existingContact.setPhoneNumber(contact.getPhoneNumber());
            existingContact.setUser(contact.getUser());
            return contactRepository.save(existingContact);
        }
        return null;
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}