package org.work.test.calculate;

import java.math.BigDecimal;
import java.util.*;


public class Ideon {
    public static BigDecimal patternVariable(String inputStr) {
        CalcMap calcMap = new CalcMap();
        String variableStr = inputStr.replaceAll("[$\\{\\}]", "");
        for (Map.Entry<String, BigDecimal> entry : calcMap.mapVariableList().entrySet()) {
            String getKey = entry.getKey();
            if (getKey.startsWith(variableStr)) {
                BigDecimal varMap;
                varMap = entry.getValue();
                return varMap;
            }
        }
        return new BigDecimal(Double.valueOf(inputStr));
    }

    public static BigDecimal calc(List<String> postfix) {
        Deque<BigDecimal> stack = new ArrayDeque<BigDecimal>();

        for (String x : postfix) {
            if (x.equals("+")) stack.push(stack.pop().add(stack.pop()));
            else if (x.equals("-")) {
                BigDecimal b = stack.pop(), a = stack.pop();
                stack.push(a.subtract(b));
            } else if (x.equals("*")) stack.push(stack.pop().multiply(stack.pop()));
            else if (x.equals("/")) {
                BigDecimal b = stack.pop(), a = stack.pop();
                stack.push(a.divide(b, BigDecimal.ROUND_CEILING));
            } else if (x.equals("u-")) stack.push(new BigDecimal(-stack.pop().doubleValue()));
            else if (x.equals("^")) {
                BigDecimal b = stack.pop(), a = stack.pop();
                stack.push(new BigDecimal(Math.pow(a.doubleValue(), b.doubleValue())));
            }
            else stack.push(patternVariable(x));
        }
        return stack.pop();
    }
}
