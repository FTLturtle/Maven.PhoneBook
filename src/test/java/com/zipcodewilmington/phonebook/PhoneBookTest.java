package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {
    private PhoneBook testPhoneBook;

    @Before
    public void initialize() {
        this.testPhoneBook = new PhoneBook();
    }


    @Test
    public void addTest1() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s",
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""),
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void addTest2() {
        // Given
        String name1 = "Alice";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Bob";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s",
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""),
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void addTest3() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "987346502938475", "09164502634-9587"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s\n%s %s",
                name3, Arrays.toString(phoneNumbers3).replaceAll("[\\[\\]]", ""),
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""),
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void removeTest1() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s",
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.remove(name1, phoneNumbers1);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void removeTest2() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s",
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.remove(name2, phoneNumbers2);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void removeTest3() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s",
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""),
                name1, phoneNumbers1[1]);

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.remove(name1, phoneNumbers1[0]);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void removeTest4() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s",
                name2, phoneNumbers2[0],
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.remove(name2, phoneNumbers2[1]);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void removeRecordTest1() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "987346502938475", "09164502634-9587"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s",
                name3, Arrays.toString(phoneNumbers3).replaceAll("[\\[\\]]", ""),
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);

        testPhoneBook.removeRecord(name1);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void removeRecordTest2() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "987346502938475", "09164502634-9587"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s",
                name3, Arrays.toString(phoneNumbers3).replaceAll("[\\[\\]]", ""),
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        testPhoneBook.removeRecord(name2);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void removeRecordTest3() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "987346502938475", "09164502634-9587"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s",
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""),
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        testPhoneBook.removeRecord(name3);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void getArrayListForTest1() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        ArrayList<String> expectedArrayList = new ArrayList<String>(Arrays.asList(phoneNumbers2));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        ArrayList<String> actualArrayList = testPhoneBook.getArrayListFor(name2);

        // Then
        Assert.assertEquals(expectedArrayList, actualArrayList);
    }

    @Test
    public void getArrayListForTest2() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        ArrayList<String> expectedArrayList = null;

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        ArrayList<String> actualArrayList = testPhoneBook.getArrayListFor("Frank");

        // Then
        Assert.assertEquals(expectedArrayList, actualArrayList);
    }

    @Test
    public void getStringOfPhoneNumbersForTest1() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedStringOfPhoneNumbers = Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", "");

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        String actualStringOfPhoneNumbers = testPhoneBook.getStringOfPhoneNumbersFor(name1);

        // Then
        Assert.assertEquals(expectedStringOfPhoneNumbers, actualStringOfPhoneNumbers);
    }

    @Test
    public void getStringOfPhoneNumbersForTest2() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String expectedStringOfPhoneNumbers = "";

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        String actualStringOfPhoneNumbers = testPhoneBook.getStringOfPhoneNumbersFor("Frank");

        // Then
        Assert.assertEquals(expectedStringOfPhoneNumbers, actualStringOfPhoneNumbers);
    }

    @Test
    public void reverseLookupTest1() {
        // Given
        String phoneNumberToLookup = "9870786543";

        String name1 = "Bob";
        String[] phoneNumbers1 = {phoneNumberToLookup, "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "987346502938475", "09164502634-9587"};

        String expectedReverseLookupResult = name1;

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        String actualListOfNames = testPhoneBook.reverseLookup(phoneNumberToLookup);

        // Then
        Assert.assertEquals(expectedReverseLookupResult, actualListOfNames);
    }

    @Test
    public void reverseLookupTest2() {
        // Given
        String phoneNumberToLookup = "9870786543";

        String name1 = "Bob";
        String[] phoneNumbers1 = {phoneNumberToLookup, "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", phoneNumberToLookup, "09164502634-9587"};

        String expectedReverseLookupResult = name3 + "\n" + name1;

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        String actualListOfNames = testPhoneBook.reverseLookup(phoneNumberToLookup);

        // Then
        Assert.assertEquals(expectedReverseLookupResult, actualListOfNames);
    }

    @Test
    public void reverseLookupTest3() {
        // Given
        String phoneNumberToLookup = "0000000000";

        String name1 = "Bob";
        String[] phoneNumbers1 = {"90091723004", "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "86298347692", "09164502634-9587"};

        String expectedReverseLookupResult = "";

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        String actualListOfNames = testPhoneBook.reverseLookup(phoneNumberToLookup);

        // Then
        Assert.assertEquals(expectedReverseLookupResult, actualListOfNames);
    }

    @Test
    public void getListOfNamesTest1() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "987346502938475", "09164502634-9587"};

        String expectedListOfNames = String.format("%s\n%s\n%s", name3, name2, name1);

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        String actualListOfNames = testPhoneBook.getListOfNames();

        // Then
        Assert.assertEquals(expectedListOfNames, actualListOfNames);
    }

    @Test
    public void getListOfNamesTest2() {

        String expectedListOfNames = "";

        // When
        String actualListOfNames = testPhoneBook.getListOfNames();

        // Then
        Assert.assertEquals(expectedListOfNames, actualListOfNames);
    }

    @Test
    public void getListOfNamesAndPhoneNumbersTest1() {
        // Given
        String name1 = "Bob";
        String[] phoneNumbers1 = {"9870786543", "8759196783", "019834759083745"};

        String name2 = "Alice";
        String[] phoneNumbers2 = {"38765920367", "9087378376"};

        String name3 = "Abraham";
        String[] phoneNumbers3 = {"78787656367", "987346502938475", "09164502634-9587"};

        String expectedListOfNamesAndPhoneNumbers = String.format("%s %s\n%s %s\n%s %s",
                name3, Arrays.toString(phoneNumbers3).replaceAll("[\\[\\]]", ""),
                name2, Arrays.toString(phoneNumbers2).replaceAll("[\\[\\]]", ""),
                name1, Arrays.toString(phoneNumbers1).replaceAll("[\\[\\]]", ""));

        // When
        testPhoneBook.add(name1, phoneNumbers1);
        testPhoneBook.add(name2, phoneNumbers2);
        testPhoneBook.add(name3, phoneNumbers3);
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }

    @Test
    public void getListOfNamesAndPhoneNumbersTest2() {
        // Given
        String expectedListOfNamesAndPhoneNumbers = "";

        // When
        String actualListOfNamesAndPhoneNumbers = testPhoneBook.getListOfNamesAndPhoneNumbers();

        // Then
        Assert.assertEquals(expectedListOfNamesAndPhoneNumbers, actualListOfNamesAndPhoneNumbers);
    }


}
