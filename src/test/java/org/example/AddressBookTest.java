package org.example;

import static org.junit.Assert.*;

public class AddressBookTest {

    AddressBook ab = new AddressBook();

    @org.junit.Test
    public void addBuddy() {
        BuddyInfo bi1 = new BuddyInfo(1L, "James", "700");
        ab.addBuddy(bi1);
        assertEquals("James", ab.buddies.get(0).getName());
        assertEquals("700", ab.buddies.get(0).getNumber());

        BuddyInfo bi2 = new BuddyInfo(2L, "Bond", "007");
        ab.addBuddy(bi2);
        assertEquals("James", ab.buddies.get(0).getName());
        assertEquals("700", ab.buddies.get(0).getNumber());
        assertEquals("Bond", ab.buddies.get(1).getName());
        assertEquals("007", ab.buddies.get(1).getNumber());
    }

    @org.junit.Test
    public void removeBuddy() {
        BuddyInfo bi3 = new BuddyInfo(3L, "Harry", "121");
        BuddyInfo bi4 = new BuddyInfo(4L, "Potter", "323");
        ab.addBuddy(bi3);
        ab.addBuddy(bi4);

        assertTrue(ab.removeBuddy("Harry"));
        assertFalse(ab.removeBuddy("121"));
        assertTrue(ab.removeBuddy("323"));
        assertFalse(ab.removeBuddy("Potter"));
    }

    @org.junit.Test
    public void emptyList() {
        BuddyInfo bi3 = new BuddyInfo(3L, "Harry", "121");
        BuddyInfo bi4 = new BuddyInfo(4L, "Potter", "323");
        ab.addBuddy(bi3);
        ab.addBuddy(bi4);

        assertFalse(ab.buddies.isEmpty());
        ab.emptyList();
        assertTrue(ab.buddies.isEmpty());
    }
}