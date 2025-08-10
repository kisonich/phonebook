package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {
    private final Map<String, String> nameToNumber = new HashMap<>();
    private final Map<String, String> numberToName = new HashMap<>();

    public int add(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("Name and number cannot be null");
        }
        if (!nameToNumber.containsKey(name)) {
            nameToNumber.put(name, number);
            numberToName.put(number, name);
        }
        return nameToNumber.size();
    }

    public String findByNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("Number cannot be null");
        }
        return numberToName.get(number);
    }

    public String findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        return nameToNumber.get(name);
    }

    public void printAllNames() {
        new TreeSet<>(nameToNumber.keySet()).forEach(System.out::println);
    }
}