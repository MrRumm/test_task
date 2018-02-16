package org.work.test.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalcMap {
    public static Map<String, Integer> mapVariableList(){
        Map<String, Integer> mapVariableList = new HashMap<String, Integer>();

        mapVariableList.put("current_year", 2018);

        return mapVariableList;
    }

    public static boolean findValue(String mask) {
        int i = 0;
        for(Map.Entry<String, Integer> entry : mapVariableList().entrySet()) {
            String varKey = entry.getKey();
            if(varKey.startsWith(mask)) {
                i++;
                return true;
            }
        }
        return false;
    }
}
