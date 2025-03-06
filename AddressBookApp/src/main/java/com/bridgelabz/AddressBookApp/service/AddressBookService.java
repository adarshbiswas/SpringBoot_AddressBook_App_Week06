package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.model.AddressBookEntity;
import com.bridgelabz.AddressBookApp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookService {

    @Autowired
    private static AddressBookRepository addressBookRepository;

    // Constructor-based dependency injection
    public AddressBookService(AddressBookRepository addressBookRepository) {
        AddressBookService.addressBookRepository = addressBookRepository;
    }

    //    Get all entries
    public List<AddressBookEntity> getAllEntries() {
        log.info("Fetching all the entries from the repository");
        List<AddressBookEntity> entries = addressBookRepository.findAll();
        if (entries.isEmpty()) {
            log.warn("No address book entries found.");
            return Collections.emptyList();
        }
        return entries;
    }

    //    Get Entry by ID
    public static Optional<AddressBookEntity> getEntryById(Long id) {
        log.info("Fetching an entry based on it's ID: {}", id);
        return addressBookRepository.findById(id);
    }

    //    Add new entry
    public AddressBookEntity addEntry(AddressBookEntity entry) {
        log.info("New Entry added successfully!");
        return addressBookRepository.save(entry);
    }

    //    Update an entry by ID
    public Optional<AddressBookEntity> updatedEntry(Long id, AddressBookEntity updatedEntry) {
        log.info("Updating Address Book using ID: {}", id);
        return addressBookRepository.findById(id).map(entry -> {
            updateEntryFields(entry, updatedEntry);
            log.info("Successfully updated entry with ID: {}", id);
            return addressBookRepository.save(entry);
        });
    }

    private void updateEntryFields(AddressBookEntity entry, AddressBookEntity updatedEntry) {
        entry.setName(updatedEntry.getName());
        entry.setPhoneNumber(updatedEntry.getPhoneNumber());
        entry.setEmail(updatedEntry.getEmail());
        entry.setCity(updatedEntry.getCity());
        entry.setPincode(updatedEntry.getPincode());
    }

    //    Delete an entry
    public boolean deleteEntry(Long id) {
        if (addressBookRepository.existsById(id)) {
            addressBookRepository.deleteById(id);
            log.info("Deleted address book entry with ID: {}", id);
            return true;
        } else {
            log.warn("Attempted to delete non-existing entry with ID: {}", id);
            return false;
        }
    }

}
