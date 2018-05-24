package org.work.test;

import org.work.test.NetAddressClass.Address;

import java.util.Scanner;

/**
 * Выводит промежуточные адреса между двумя введёнными пользователем
 */
public class NetAddressTask {

    public static void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        System.out.println("Введите первый адрес:");
        String stringIp1 = in1.nextLine();
        Address firstIp = new Address(stringIp1);

        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите второй адрес:");
        String stringIp2 = in2.nextLine();
        Address secondIp = new Address(stringIp2);

        int result = firstIp.compareTo(secondIp);
        while (result != 0) {
            if(firstIp.checkRange() == true) {
                if (result > 0) {
                    firstIp.incrementIp();
                } else if (result < 0) {
                    firstIp.decrementIp();
                }
            } else {
                throw new IllegalArgumentException("Адрес " + firstIp.getAsLong() + " вышел за пределы диапазона!!!");
            }
            if(firstIp.compareTo(secondIp) != 0) {
                System.out.println(firstIp.longToIp(firstIp.getAsLong()));
            }
            result = firstIp.compareTo(secondIp);
        }

    }
}
