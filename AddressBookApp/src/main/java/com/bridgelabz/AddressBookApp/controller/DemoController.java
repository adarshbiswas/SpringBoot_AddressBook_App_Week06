package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class DemoController {

    @GetMapping
    public String getHello() {
        return "Hello from BridgeLabz!!!";
    }

    @PostMapping("/post")
    public ResponseEntity<String> postHello(@RequestBody User user) {
        String message = "Hello! " + user.getFirst_name() + " " + user.getLast_name() + ", Welcome to BridgeLabz1";
        return ResponseEntity.ok(message);
    }

    @PutMapping("/put/{first_name}")
    public ResponseEntity<String> putHello(@PathVariable String first_name) {
        String updatedMessage = "Hi! " + first_name;
        return ResponseEntity.ok(updatedMessage);
    }

    @DeleteMapping("/delete")
    public String deleteData() {
        return "Data deleted successfully!";
    }

}
