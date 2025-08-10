package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhoneBookTest {
    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add("Alice", "12345"));
        assertEquals(2, phoneBook.add("Bob", "67890"));
        assertEquals(2, phoneBook.add("Alice", "99999"));
    }

    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");

        assertEquals("Alice", phoneBook.findByNumber("12345"));
        assertEquals("Bob", phoneBook.findByNumber("67890"));
        assertNull(phoneBook.findByNumber("00000"));
    }

    @Test
    public void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "12345");
        phoneBook.add("Bob", "67890");

        assertEquals("12345", phoneBook.findByName("Alice"));
        assertEquals("67890", phoneBook.findByName("Bob"));
        assertNull(phoneBook.findByName("Charlie"));
    }

    @Test
    public void testPrintAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Bob", "67890");
        phoneBook.add("Alice", "12345");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneBook.printAllNames();

        String expected = "Alice" + System.lineSeparator() + "Bob";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void testAddNull() {
        PhoneBook phoneBook = new PhoneBook();
        assertThrows(IllegalArgumentException.class, () -> phoneBook.add(null, "123"));
        assertThrows(IllegalArgumentException.class, () -> phoneBook.add("Name", null));
    }

    @Test
    public void testFindByNumberNull() {
        PhoneBook phoneBook = new PhoneBook();
        assertThrows(IllegalArgumentException.class, () -> phoneBook.findByNumber(null));
    }

    @Test
    public void testFindByNameNull() {
        PhoneBook phoneBook = new PhoneBook();
        assertThrows(IllegalArgumentException.class, () -> phoneBook.findByName(null));
    }
}