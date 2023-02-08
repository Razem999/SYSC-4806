package org.example;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {
    private Long id;
    private String name;
    private String number;
    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo(){
    }

    public BuddyInfo(Long id, String n, String p) {
        this.id = id;
        this.name = n;
        this.number = p;
    }

    public BuddyInfo(String n, String p) {
        this.name = n;
        this.number = p;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @ManyToOne
//    public AddressBook getAddressBook() {
//        return addressBook;
//    }
//
//    public void setAddressBook(AddressBook ab) {
//        this.addressBook = ab;
//    }

    public void setName(String n) {
        this.name = n;
    }

    public void setNumber(String n) {
        this.number = n;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }
}
