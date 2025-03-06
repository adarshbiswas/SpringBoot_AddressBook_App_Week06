package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.DTO.AddressBookEntryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    //    List to store Entries
    private final List<AddressBookEntryDTO> addressBook = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    //    Get all entries
    @GetMapping("/get_entry")
    public ResponseEntity<List<AddressBookEntryDTO>> getEntries() {
        return ResponseEntity.ok(addressBook);
    }

    //    Add new entry
    @PostMapping("/add_entry")
    public ResponseEntity<String> addEntry(@RequestBody AddressBookEntryDTO entry) {
        entry.setId(counter.getAndIncrement());
        addressBook.add(entry);
        return ResponseEntity.status(HttpStatus.CREATED).body("Entry added successfully!");
    }

    //    Update an entry
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable Long id, @RequestBody AddressBookEntryDTO updatedEntry) {
        for (int i = 0; i < addressBook.size(); i++) {
            if (addressBook.get(i).getId().equals(id)) {
                updatedEntry.setId(id);
                addressBook.set(i, updatedEntry);
                return ResponseEntity.ok("Entry updated successfully!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
    }

    //    Delete an entry
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        boolean removed = addressBook.removeIf(entry -> entry.getId().equals(id));

        if (removed) {
            return ResponseEntity.ok("Entry deleted successfully!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
    }

}
