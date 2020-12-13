package com.bl.addressbookapp.repository;

import com.bl.addressbookapp.domain.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook,Long> {
}
