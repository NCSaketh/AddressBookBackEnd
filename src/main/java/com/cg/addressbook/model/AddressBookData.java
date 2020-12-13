//@Pattern(regexp = "^[a-zA-Z0-9+_-]+([.][a-zA-Z0-9]+)*@([a-zA-Z0-9]+)([.][a-z]+)?[.][a-z]{2,}$", message = "incorrect email address")
package com.cg.addressbook.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

public class AddressBookData {

    private String id;
    @NotNull(message = "Please provide first Name")
    @NotEmpty(message = "Please provide first Name")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-]*$", message = "incorrect first name")
    private String firstName;

    @NotNull(message = "Please provide last Name")
    @NotEmpty(message = "Please provide last Name")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-]*$", message = "incorrect last name")
    private String lastName;

    @NotNull(message = "Please provide email")
    @NotEmpty(message = "Please provide email")
    private String email;

    @NotNull(message = "Please provide address")
    @NotEmpty(message = "Please provide address")
    private String address;

    @NotNull(message = "Please provide phone number")
    @NotEmpty(message = "Please provide phone number")
    @Pattern(regexp = "^[0-9]{1,}[ ][1-9]{1}[0-9]{9}$", message = "incorrect phone number")

    List<String> phoneNumbers;

    public AddressBookData(String firstName, String lastName, String email, String address, List<String> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookData addressBookData = (AddressBookData) o;
        return Objects.equals(firstName, addressBookData.firstName) &&
                Objects.equals(lastName, addressBookData.lastName) &&
                Objects.equals(email, addressBookData.email) &&
                Objects.equals(address, addressBookData.address) &&
                phoneNumbers.containsAll(addressBookData.getPhoneNumbers())
                && addressBookData.getPhoneNumbers().containsAll(phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, address, phoneNumbers);
    }
}



