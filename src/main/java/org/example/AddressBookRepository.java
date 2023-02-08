package org.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
//    List<AddressBook> findAddressBookByBookName(String bookName);
//
    AddressBook findAddressBookById(Long id);
}
