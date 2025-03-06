package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.model.AddressBookEntity;
import com.bridgelabz.AddressBookApp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    //    Get all entries
    @GetMapping("/get_entry")
    public ResponseEntity<List<AddressBookEntity>> getEntries() {
        return ResponseEntity.ok(addressBookService.getAllEntries());
    }

    //    Get an entry by ID
    @GetMapping("/get_entry/{id}")
    public ResponseEntity<AddressBookEntity> getEntryById(@PathVariable Long id) {
        Optional<AddressBookEntity> entry = AddressBookService.getEntryById(id);
        return entry.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    //    Add new entry
    @PostMapping("/add_entry")
    public ResponseEntity<AddressBookEntity> addEntry(@RequestBody AddressBookEntity entry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressBookService.addEntry(entry));
    }

    //    Update an entry
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable Long id, @RequestBody AddressBookEntity updatedEntry) {
        Optional<AddressBookEntity> isUpdated = addressBookService.updatedEntry(id, updatedEntry);
        if (isUpdated.isPresent()) {
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
