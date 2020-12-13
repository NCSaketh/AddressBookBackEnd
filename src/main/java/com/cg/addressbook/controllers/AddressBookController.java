package com.cg.addressbook.controllers;

import com.cg.addressbook.model.AddressBookData;
import com.cg.addressbook.services.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController

public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    //http:localhost/address-book/ADDRESS_BOOK_1/contacts
    @PostMapping("/{addressBookId}/contacts")
    public AddressBookData addContactToAddressBook(
            @PathVariable String addressBookId, @Valid @RequestBody AddressBookData newAddressBookData) {
        return addressBookService.addContact(addressBookId, newAddressBookData);
    }

    //http:localhost/address-book/ADDRESS_BOOK_1/contacts/1
    @DeleteMapping("/{addressBookId}/contacts/{contactId}")
    public AddressBookData removeContactFromAddressBook(@PathVariable String addressBookId,
                                                        @PathVariable String contactId) {
        return addressBookService.removeContact(addressBookId, contactId);
    }

    //http:localhost/address-book/ADDRESS_BOOK_1/contacts
    @GetMapping("/{addressBookId}/contacts")
    public List<AddressBookData> retrieveContactsFromAddressBook(@PathVariable String addressBookId) {
        return addressBookService.retrieveContacts(addressBookId);
    }

    @GetMapping("/contacts")
    public List<AddressBookData> retrieveUniqueContactsFromAllAddressBooks(@RequestParam(value = "unique", defaultValue = "false") Boolean unique) {
        return addressBookService.retrieveAllUniqueContacts(unique);
    }
}

