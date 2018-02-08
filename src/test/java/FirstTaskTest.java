import org.junit.Test;
import org.work.test.FirstTask;
import org.work.test.FirstTaskClass.Address;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FirstTaskTest {
    @Test
    public void testIntAndLongCompare() {
        long value = 3232235776L;
        assertTrue(value > 0xffffffff);
    }

    @Test
    public void testCompareToTrue() {
        String stringIp1 = "192.168.0.1";
        String stringIp2 = "192.168.0.2";

        Address firstIp = new Address(stringIp1);
        Address secondIp = new Address(stringIp2);

        int result = firstIp.compareTo(secondIp);

        assertTrue(result == 1);
        assertFalse(result == -1);
        assertFalse(result == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateIp() {
        String valIp = "192.1681.0.1";
        String str = "test string";

        Address testIp = new Address(str);
        Address testIp2 = new Address(valIp);
    }

    @Test
    public void testIpToLong() {
        String valIp = "192.168.0.1";

        Address testIp = new Address(valIp);

        assertTrue(testIp.getAsLong() > 0L);
        assertTrue(testIp.getAsLong() < 0xffffffffL);
    }

    @Test
    public void testLongToIp() {
        String valIp = "192.168.0.1";
        String valIp2 = "192.168.0.2";
        Address testIp = new Address(valIp);

        assertTrue(valIp.equals(testIp.longToIp(testIp.getAsLong())));
        assertFalse(valIp2.equals(testIp.longToIp(testIp.getAsLong())));
    }
}
