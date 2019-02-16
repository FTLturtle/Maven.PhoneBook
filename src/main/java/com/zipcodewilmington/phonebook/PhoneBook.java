package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private TreeMap<String, ArrayList<String>> phoneBookTreeMap = new TreeMap<>();


    /**
     * This method adds the name and array of phone phone numbers(converted to an arraylist) as a key-value
     * mapping to the phoneBookTreeMap.
     *
     * @param name          to add as key
     * @param phoneNumbers: phone phone numbers to add as values to the arraylist associated with the key
     */
    public void add(String name, String... phoneNumbers) {
        ArrayList<String> phoneNumbersToAdd = new ArrayList<>(Arrays.asList(phoneNumbers));

        if (hasEntry(name)) {
            ArrayList<String> oldPhoneNumbers = phoneBookTreeMap.get(name);
            phoneNumbersToAdd.addAll(oldPhoneNumbers);
        }

        phoneBookTreeMap.put(name, phoneNumbersToAdd);
    }

    /**
     * This method removes a phone phone number from one of the names in the phoneBookTreeMap. If all the phone numbers
     * associated with a name have been removed, then it gets rid of the entry altogether.
     *
     * @param name:         name to remove as a key
     * @param phoneNumbers: phone numbers to add as the associated value
     */
    public void remove(String name, String... phoneNumbers) {
        ArrayList<String> phoneNumbersToRemove = new ArrayList<>(Arrays.asList(phoneNumbers));

        if (hasEntry(name)) {
            ArrayList<String> oldPhoneNumbers = phoneBookTreeMap.get(name);
            oldPhoneNumbers.removeAll(phoneNumbersToRemove);
            phoneBookTreeMap.put(name, oldPhoneNumbers);

            if (phoneBookTreeMap.get(name).isEmpty()) {
                removeRecord(name);
            }
        }

    }

    /**
     * void method that removes an entry from the phoneBookTreeMap
     *
     * @param name of entry to remove
     */
    public void removeRecord(String name) {
        phoneBookTreeMap.remove(name);
    }

    /**
     * This method returns the Value (ArrayList of String phone numbers) for which the specified key (String name) is mapped.
     *
     * @param name the name to look up in the phone book
     * @return the Value (ArrayList of phone numbers) associated with the key (String name), or
     * null if the entry is not found
     */
    public ArrayList<String> getArrayListFor(String name) {
        return phoneBookTreeMap.get(name);
    }

    /**
     * This method returns the String of phone numbers (ArrayList of String phone numbers converted to String) for which
     * the specified key (String name) is mapped.
     *
     * @param name the name to look up in the phone book
     * @return the String of phone numbers (ArrayList of phone numbers converted to String) associated with the key (String name),
     * or an empty string if the entry is not found
     */
    public String getStringOfPhoneNumbersFor(String name) {
        ArrayList<String> arrayListOfPhoneNumbers = getArrayListFor(name);

        if (arrayListOfPhoneNumbers != null) {
            return phoneBookTreeMap.get(name).toString().replaceAll("[\\[\\]]", "").replaceAll("\\n$", "");
        }

        return "";
    }

    /**
     * This method does a reverse lookup. It looks for every Key (String name) whose Value (an ArrayList of Strings)
     * contains the specified String phone number. It returns a String list of names associated with that phone number, or an
     * empty string if no names are found associated with that phone number.
     *
     * @param phoneNumber: specified phone number used to find the names associated with it
     * @return String names associated with specified phoneNumber
     */
    public String reverseLookup(String phoneNumber) {
        StringBuilder name = new StringBuilder();

        for (String key : this.phoneBookTreeMap.keySet()) {
            if (phoneBookTreeMap.get(key).contains(phoneNumber)) {
                name.append(key).append("\n");
            }
        }

        return name.toString().replaceAll("[\\[\\]]", "").replaceAll("\\n$", "");
    }

    /**
     * This is a getter method to get a string with the list of all names and phone numbers in this phone book
     * in this sort of format:
     * "name1 phoneNumber1, phoneNumber2, phoneNumber3\n" +
     * "name2 phoneNumber1, phoneNumber2" +
     * "name3 phoneNumber1, phoneNumber2, phoneNumber3"
     *
     * @return a string of all the names and phone numbers in the phone book
     */
    public String getListOfNamesAndPhoneNumbers() {
        StringBuilder phoneBookList = new StringBuilder();

        for (String key : this.phoneBookTreeMap.keySet()) {
            phoneBookList.append(key).append(" ").append(phoneBookTreeMap.get(key)).append("\n");
        }

        return phoneBookList.toString().replaceAll("[\\[\\]]", "").replaceAll("\\n$", "");
    }

    /**
     * returns a String list of the names contained in the phoneBookTreeMap.
     *
     * @return String list of names in phoneBookTreeMap
     */
    public String getListOfNames() {
        StringBuilder phoneBookList = new StringBuilder();

        for (String key : this.phoneBookTreeMap.keySet()) {
            phoneBookList.append(key).append("\n");
        }

        return phoneBookList.toString().replaceAll("\\n$", "");
    }

    /**
     * This is a private method to check if an entry is present in the phone book tree map. returns true
     * if the entry is present, and false otherwise.
     *
     * @param name: the name to check
     * @return true if the map has an entry with that name, and false otherwise
     */
    private boolean hasEntry(String name) {
        return phoneBookTreeMap.containsKey(name);
    }

}
