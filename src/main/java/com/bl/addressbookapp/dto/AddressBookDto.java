package com.bl.addressbookapp.dto;

import com.bl.addressbookapp.domain.AddressBook;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Getter
@Setter
public class AddressBookDto {

    private Long id;
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Contact Name Invalid!")
    private String name;
    @NotEmpty(message = "Address Can't Be Empty!")
    private String address;
    @NotEmpty(message = "City Can't Be Empty!")
    private String city;
    @NotEmpty(message = "State Can't Be Empty!")
    private String state;
    @NotEmpty(message = "Zip Can't Be Empty!")
    private String zip;
    @Pattern(regexp = "^[98][0-9]{9}$", message = "Mobile No Invalid!")
    private String phone;

    public AddressBookDto() {
    }

    public AddressBookDto(AddressBook addressBook) {
        this.id = addressBook.getId();
        this.name = addressBook.getName();
        this.address = addressBook.getAddress();
        this.city = addressBook.getCity();
        this.state = addressBook.getState();
        this.zip = addressBook.getZip();
        this.phone = addressBook.getPhone();
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
