package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.DTO.AddressBookEntryDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService {

    //    List to store Entries
    private final List<AddressBookEntryDTO> addressBook = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    //    Get all entries
    public List<AddressBookEntryDTO> getAllEntries() {
        return addressBook;
    }

    //    Add new entry
    public AddressBookEntryDTO addEntry(AddressBookEntryDTO entry) {
        entry.setId(counter.getAndIncrement());
        addressBook.add(entry);
        return entry;
    }

    //    Update an entry
    public boolean updateEntry(Long id, AddressBookEntryDTO updatedEntry) {
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getId().equals(id)) {
                updatedEntry.setId(id);
                addressBook.set(i, updatedEntry);
                return true;
            }
        }
        return false;
    }

    //    Delete an entry
    public boolean deleteEntry(Long id) {
        return addressBook.removeIf(entry -> entry.getId().equals(id));
    }

}
