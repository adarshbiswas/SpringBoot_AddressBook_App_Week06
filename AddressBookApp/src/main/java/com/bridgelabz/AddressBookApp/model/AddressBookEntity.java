package com.bridgelabz.AddressBookApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "addressBook")

public class AddressBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String city;
    private int pincode;

    //    Constructors
    public AddressBookEntity() {
    }

    public AddressBookEntity(Long id, String name, String phoneNumber, String email, String city, int pincode) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.pincode = pincode;
    }

    //    Getters
    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public int getPincode() {
        return pincode;
    }

    //    Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
