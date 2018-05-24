package org.work.test.calculate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CalcMap {
    public static Map<String, BigDecimal> mapVariableList(){
        Map<String, BigDecimal> mapVariableList = new HashMap<String, BigDecimal>();
        BigDecimal year = new BigDecimal(2018);
        mapVariableList.put("current_year", year);

        return mapVariableList;
    }
}
