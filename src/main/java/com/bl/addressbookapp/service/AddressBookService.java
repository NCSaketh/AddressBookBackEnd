package com.bl.addressbookapp.service;

import com.bl.addressbookapp.domain.AddressBook;
import com.bl.addressbookapp.dto.AddressBookDto;
import com.bl.addressbookapp.exceptions.DetailsNotProvidedExceptions;
import com.bl.addressbookapp.exceptions.RecordNotFound;
import com.bl.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookDto CreateContact(AddressBookDto addressBookDto) {
        if(Objects.nonNull(addressBookDto.getName()) &&
            Objects.nonNull(addressBookDto.getAddress()) &&
            Objects.nonNull(addressBookDto.getCity()) &&
            Objects.nonNull(addressBookDto.getState()) &&
            Objects.nonNull(addressBookDto.getZip()) &&
            Objects.nonNull(addressBookDto.getPhone())
        ) {
            AddressBook addressBook = new AddressBook(addressBookDto.getName(),
                    addressBookDto.getAddress(),
                    addressBookDto.getCity(),
                    addressBookDto.getState(),
                    addressBookDto.getZip(),
                    addressBookDto.getPhone());
            return new AddressBookDto(addressBookRepository.save(addressBook));
        }
        throw new DetailsNotProvidedExceptions("Invalid Input!");
    }

    public AddressBookDto UpdateContact(AddressBookDto addressBookDto) {
        return addressBookRepository.findById(addressBookDto.getId()).map(contact -> {
            if(Objects.nonNull(addressBookDto.getName())) {
                contact.setName(addressBookDto.getName());
            }
            if(Objects.nonNull(addressBookDto.getAddress())) {
                contact.setAddress(addressBookDto.getAddress());
            }
            if(Objects.nonNull(addressBookDto.getCity())) {
                contact.setCity(addressBookDto.getCity());
            }
            if(Objects.nonNull(addressBookDto.getState())) {
                contact.setState(addressBookDto.getState());
            }
            if(Objects.nonNull(addressBookDto.getZip())) {
                contact.setZip(addressBookDto.getZip());
            }
            if(Objects.nonNull(addressBookDto.getPhone())) {
                contact.setPhone(addressBookDto.getPhone());
            }
            return new AddressBookDto(addressBookRepository.save(contact));
        }).orElseThrow(()-> new RecordNotFound("Record Not Found!"));
    }

    public AddressBookDto deleteContact(Long id) {
        return addressBookRepository.findById(id).map(contact -> {
            addressBookRepository.deleteById(contact.getId());
            return new AddressBookDto(contact);
        }).orElseThrow(()-> new RecordNotFound("Record Not Found!"));
    }

    public List<AddressBookDto> getAllContacts() {
        return addressBookRepository.findAll()
                .stream()
                .map(contact -> new AddressBookDto(contact))
                .collect(Collectors.toList());
    }
}
