package lection1;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<Integer>> contacts;
    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addNumber("Саша", 12347567);
        phoneBook.addNumber("Маша", 98786543);
        phoneBook.addNumber("Саша", 88965667);
        phoneBook.addNumber("Саша", 56106667);
        phoneBook.addNumber("Саша", 5556667);
        phoneBook.addNumber("Даша", 5789246);
        phoneBook.addNumber("Маша", 22488628);
        phoneBook.printBook();
    }

    public void addNumber(String name, Integer phoneNumber) {
        contacts.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void printBook() {
        List<Map.Entry<String, Set<Integer>>> sortedContacts = new ArrayList<>(contacts.entrySet());

        sortedContacts.sort((entry1, entry2) -> {
            int size1 = entry1.getValue().size();
            int size2 = entry2.getValue().size();
            return Integer.compare(size2, size1);
        });

        for (Map.Entry<String, Set<Integer>> entry : sortedContacts) {
            String name = entry.getKey();
            Set<Integer> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
