package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "buddy_info")
    List<BuddyInfo> buddies = new ArrayList<>();
    private String bookName;

    public AddressBook(){

    }

    public AddressBook(Long id, String n) {
        this.id = id;
        this.bookName = n;
    }

    public AddressBook(String n) {
        this.bookName = n;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    public void addBuddy(BuddyInfo bi) {
        buddies.add(bi);
    }

    public void addBuddy(String name, String number) {
        BuddyInfo buddyInfo = new BuddyInfo(name, number);
        buddies.add(buddyInfo);
    }

    public boolean removeBuddy(String n) {
        for(int i = 0; i < buddies.size(); i++) {
            if(buddies.get(i).getName().equals(n) || buddies.get(i).getNumber().equals(n)) {
                buddies.remove(i);
                return true;
            }
        }
//        System.out.println("This name/number does not exist in this Address Book.");
        return false;
    }

    public String toString() {
        return String.format("AddressBook[id=%d, bookName='%s']", id, bookName);
    }

    public String buddyToString() {
        String buds = "";
        for(BuddyInfo b : buddies) {
            buds += String.format("Buddy[id=%d, Name='%s', Number='%s']\n", b.getId(), b.getName(), b.getNumber());
        }
        return buds;
    }

    public void listBuddies() {
//        if (buddies.isEmpty()) {
//            System.out.println("You have no buddies...");
//        }
        for(int i = 0; i < buddies.size(); i++) {
//            System.out.println(buddies.get(i).getName() + " " + buddies.get(i).getNumber());
        }
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void emptyList() {
        for(int i = buddies.size() - 1; i >= 0; i--) {
            buddies.remove(i);
        }
    }

//    public static void main(String[] args) {
//        AddressBook ab = new AddressBook();
//        BuddyInfo bi1 = new BuddyInfo("Tommy", "613");
//        BuddyInfo bi2 = new BuddyInfo("Shelby", "801");
//        ab.listBuddies();
//
//        ab.addBuddy(bi1);
//        ab.addBuddy(bi2);
//        ab.listBuddies();
//
//        ab.removeBuddy("Shelby");
//        ab.listBuddies();
//
//        bi1.setName("Timmy");
//        ab.removeBuddy("Tommy");
//        ab.listBuddies();
//
//        ab.emptyList();
//        ab.listBuddies();
//        System.out.println(ab.buddies.isEmpty());
//    }
}
