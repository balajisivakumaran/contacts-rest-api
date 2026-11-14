package com.ltp.contacts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltp.contacts.pojo.Contact;

@Repository
public class ContactRepository {
    
    private List<Contact> contacts = new ArrayList<>(List.of(
        new Contact("1", "Jon Snow", "6123456432"),
        new Contact("2", "Tyrion Lannister", "4145433332"),
        new Contact("3", "The Hound", "3452125631")
    ));

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) { 
        contacts.set(index, contact); 
    }
    
    public void deleteContact(int index) {
        contacts.remove(index);
    }

}
