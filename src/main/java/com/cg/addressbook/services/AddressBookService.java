package com.cg.addressbook.services;

import com.cg.addressbook.exceptions.AddressBookException;
import com.cg.addressbook.model.AddressBookData;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    private static final String ADDRESS_BOOK_1 = "address-book-1";
    private static final String ADDRESS_BOOK_2 = "address-book-2";

    private final Map<String, List<AddressBookData>> addressBooks = new HashMap<>();

    public AddressBookService() {
        addressBooks.put(ADDRESS_BOOK_1, new ArrayList<>());
        addressBooks.put(ADDRESS_BOOK_2, new ArrayList<>());

        this.addContact(ADDRESS_BOOK_1, new AddressBookData("Abhinav","Thakur" , "at@gmail.com" ,"Delhi", Arrays.asList("9013341138")));
        this.addContact(ADDRESS_BOOK_1, new AddressBookData("Arpit","Thakur" , "at2@gmail.com" ,"Delhi", Arrays.asList("9013341139")));

        this.addContact(ADDRESS_BOOK_2, new AddressBookData("Prajwal","Rao" , "pr@gmail.com" ,"Karnataka", Arrays.asList("9013341140")));
        this.addContact(ADDRESS_BOOK_2, new AddressBookData("Manmeet","Jha" , "mj@gmail.com" ,"Delhi", Arrays.asList("9013341141")));
    }

    public AddressBookData addContact(String addressBookId, AddressBookData addressBookData) {
        addressBookData.setId(UUID.randomUUID().toString());
        if (!addressBooks.containsKey(addressBookId)) {
            addressBooks.put(addressBookId, new ArrayList<>());
        }
        addressBooks.get(addressBookId).add(addressBookData);
        return addressBookData;
    }

    public AddressBookData removeContact(String addressBookId, final String contactId) {
        if (!addressBooks.containsKey(addressBookId)) {
            throw new AddressBookException("AddressBook with the given Id does not exist");
        }
        Optional<AddressBookData> contactToBeRemoved = addressBooks.get(addressBookId).stream()
                .filter(addressBookData -> addressBookData.getId().equals(contactId)).findFirst();
        if (contactToBeRemoved.isPresent()) {
            addressBooks.get(addressBookId).remove(contactToBeRemoved.get());
            return contactToBeRemoved.get();
        } else {
            throw new AddressBookException("The given contact does not exist!");
        }
    }

    public List<AddressBookData> retrieveContacts(String addressBookId) {
        if (!addressBooks.containsKey(addressBookId)) {
            throw new AddressBookException("AddressBook with the given Id does not exist");
        }
        return addressBooks.get(addressBookId);
    }

    public List<AddressBookData> retrieveAllUniqueContacts(boolean unique) {
        // assumed that the contact is unique it's name and numbers matches
        List<AddressBookData> addressBookData = new ArrayList<>();
        addressBooks.values().forEach(addressBookData::addAll);
        if (unique) {
            return addressBookData.stream().distinct().collect(Collectors.toList());
        }
        return addressBookData;
    }
}