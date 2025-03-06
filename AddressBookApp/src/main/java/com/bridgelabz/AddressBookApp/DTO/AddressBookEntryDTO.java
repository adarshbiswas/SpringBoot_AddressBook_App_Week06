package com.bridgelabz.AddressBookApp.DTO;

public class AddressBookEntryDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String city;
    private int pincode;

    //    Constructors
    public AddressBookEntryDTO() {
    }

    public AddressBookEntryDTO(Long id, String name, String phoneNumber, String email, String city, int pincode) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.pincode = pincode;
    }

//    Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
