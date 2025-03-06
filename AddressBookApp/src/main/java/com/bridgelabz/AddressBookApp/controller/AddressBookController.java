package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.DTO.AddressBookEntryDTO;
import com.bridgelabz.AddressBookApp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    //    Get all entries
    @GetMapping("/get_entry")
    public ResponseEntity<List<AddressBookEntryDTO>> getEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    //    Add new entry
    @PostMapping("/add_entry")
    public ResponseEntity<AddressBookEntryDTO> addEntry(@RequestBody AddressBookEntryDTO entry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressBookService.addEntry(entry));
    }

    //    Update an entry
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable Long id, @RequestBody AddressBookEntryDTO updatedEntry) {
        boolean isUpdated = addressBookService.updateEntry(id, updatedEntry);
        if (isUpdated) {
            return ResponseEntity.ok("Entry updated successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
    }

    //    Delete an entry
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable Long id) {
        boolean isRemoved = addressBookService.deleteEntry(id);
        if (isRemoved) {
            return ResponseEntity.ok("Entry deleted successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entry not found!");
    }

}
