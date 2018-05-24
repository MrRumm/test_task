package org.work.test.PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    /**
     * Список для хранения телефонных номеров и соответствия с их владельцами
     * @return значение HashMap в виде владелец/телефон
     */
    public static Map<String, ArrayList<String>> mapPhoneList(){
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

    /**
     * Выполняет поиск в HashMap по отрезку имени, и выводит относящиеся к нему
     * телефонные номера
     * @param mask строчное значение, отрезок имени
     */
    public static void findValue(String mask) {
        int i = 0;
        for(Map.Entry<String, ArrayList<String>> entry : mapPhoneList().entrySet()) {
            String fullName = entry.getKey();
            if(fullName.startsWith(mask)) {
                i++;
                System.out.println("Фамилия: " + fullName);
                System.out.println("Номера:");
                System.out.println(entry.getValue());
            }
        }
        if(i == 0){
            System.out.println("Ф.И.О. " + mask + " в базе отсутствует!!!");
        }
    }

}
