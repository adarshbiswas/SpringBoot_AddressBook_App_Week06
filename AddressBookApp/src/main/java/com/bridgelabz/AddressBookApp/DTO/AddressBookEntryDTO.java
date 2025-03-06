package com.bridgelabz.AddressBookApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookEntryDTO {

    private String name;
    private String phoneNumber;
    private String email;
    private String city;
    private int pincode;

}
