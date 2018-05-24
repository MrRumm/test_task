package org.work.test;

import org.work.test.PhoneBook.Phonebook;

import java.util.*;

public class PhoneBookMain {

    public static void main(String[] args) {
        Phonebook value = new Phonebook();

        Scanner in1 = new Scanner(System.in);
        System.out.println("Введите Ф.И.О.:");
        String input1 = in1.nextLine();
        value.findValue(input1);
    }
}
