package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    BuddyInfo bi1 = new BuddyInfo(1L, "James", "700");
    BuddyInfo bi2 = new BuddyInfo(2L, "Bond", "007");

    @Test
    public void setName() {
        bi1.setName("Harry");
        assertEquals("Harry", bi1.getName());

        bi1.setName("Tom");
        assertEquals("Tom", bi1.getName());
    }

    @Test
    public void setNumber() {
        bi2.setNumber("900");
        assertEquals("900", bi2.getNumber());

        bi2.setNumber("383");
        assertEquals("383", bi2.getNumber());
    }
}