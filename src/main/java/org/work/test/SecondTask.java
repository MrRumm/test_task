package org.work.test;

import java.util.*;

public class SecondTask {
    public static  Map<String, ArrayList<String>> mapPhoneList(){
        Map<String, ArrayList<String>> mapPhoneList = new HashMap<String, ArrayList<String>>();

        ArrayList firstPhoneList = new ArrayList();
        firstPhoneList.add("8 800 2000 000");
        firstPhoneList.add("8 800 2000 100");
        mapPhoneList.put("Егоров В.В.", firstPhoneList);

        ArrayList secondPhoneList = new ArrayList();
        secondPhoneList.add("8 800 2000 200");
        mapPhoneList.put("Андреев А.А.", secondPhoneList);

        ArrayList thirdPhoneList = new ArrayList();
        thirdPhoneList.add("8 800 2000 300");
        thirdPhoneList.add("8 800 2000 400");
        thirdPhoneList.add("8 800 2000 500");
        mapPhoneList.put("Михалёв Д.Д.", thirdPhoneList);

        return mapPhoneList;
    }

    public static void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        System.out.println("Введите Ф.И.О.:");
        String input1 = in1.nextLine();

        if(mapPhoneList().containsKey(input1)) {
            System.out.println("Номера: ");
            for (String value : mapPhoneList().get(input1)) {
                System.out.println(value);
            }
        } else {
            System.out.println("Ф.И.О. " + input1 + " в базе отсутствует!!!");
        }
    }
}
