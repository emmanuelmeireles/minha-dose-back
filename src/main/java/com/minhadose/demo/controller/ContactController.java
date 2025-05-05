package com.minhadose.demo.controller;

import com.minhadose.demo.model.ContactModel;
import com.minhadose.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<ContactModel> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ContactModel getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    public ContactModel createContact(@RequestBody ContactModel contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/{id}")
    public ContactModel updateContact(@PathVariable Long id, @RequestBody ContactModel contact) {
        return contactService.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}