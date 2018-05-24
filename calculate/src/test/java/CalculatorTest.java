import org.junit.Test;
import org.work.test.calculate.ExpressionParser;
import org.work.test.calculate.Ideon;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    @Test
    public void patternVariableDouble() {
        String varStr = "12";

        assertTrue(Ideon.patternVariable(varStr) instanceof BigDecimal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionIncorrectString() {
        String incorrectString = "${asd}";

        Ideon.patternVariable(incorrectString);
    }

    @Test
    public void testPriorityExpression() {
        ExpressionParser pars = new ExpressionParser();

        String expressionStringFirst = "2+2*3";
        BigDecimal resultOneTrue = new BigDecimal(8);
        String expressionStringSecond = "(2+2)*3";
        BigDecimal resultSecondTrue = new BigDecimal(12);
        BigDecimal resultFalse = new BigDecimal(13);

        List<String> expressionPostfixFirst = pars.parse(expressionStringFirst);
        List<String> expressionPostfixSecond = pars.parse(expressionStringSecond);

        assertTrue(resultOneTrue.equals(Ideon.calc(expressionPostfixFirst)));
        assertTrue(resultSecondTrue.equals(Ideon.calc(expressionPostfixSecond)));
        assertFalse(resultFalse.equals(Ideon.calc(expressionPostfixFirst)));
        assertFalse(resultFalse.equals(Ideon.calc(expressionPostfixSecond)));
    }
}

