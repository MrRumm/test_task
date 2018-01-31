package org.work.test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Scanner;

public class FirstTask {
    public static boolean identityCheck(String[] str1, String[] str2) {
        boolean returnValue = true;
        for(int i = 0; i < 3; i++) {
            if(!str1[i].equals(str2[i])){
                returnValue = false;
                break;
            }
        }
        return returnValue;
    }

    public static boolean validateCheck(String val1, String val2) {
        boolean returnValue = false;
        String pattern = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

        if(val1.matches(pattern) && val2.matches(pattern)){
            returnValue = true;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        System.out.println("Введите первый адрес:");
        String input1 = in1.nextLine();

        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите второй адрес:");
        String input2 = in2.nextLine();

        if (validateCheck(input1, input2) == true) {

            String[] str1 = input1.split("\\.");
            Integer numCh1 = Integer.valueOf(str1[3]);

            String[] str2 = input2.split("\\.");
            Integer numCh2 = Integer.valueOf(str2[3]);

            if (identityCheck(str1, str2) == true) {
                System.out.println("Результат:");
                if (numCh1 < numCh2) {
                    for (int i = numCh1; i < numCh2 - 1; i++) {
                        if (numCh1 < numCh2) {
                            numCh1++;
                        }
                        System.out.println(str1[0] + "." + str1[1] + "." + str1[2] + "." + numCh1);
                    }
                } else {
                    for (int i = numCh2 - 1; i < numCh1; i++) {
                        if (numCh2 < numCh1) {
                            numCh1--;
                        }
                        System.out.println(str1[0] + "." + str1[1] + "." + str1[2] + "." + numCh1);
                    }
                }
            } else {
                System.out.print("Ошибка в идентичности адресов!!!");
            }
        } else {
            System.out.print("Ошибка в корректности адресов!!!");
        }

    }
}
