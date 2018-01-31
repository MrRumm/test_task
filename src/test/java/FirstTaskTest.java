import org.junit.Test;
import org.work.test.FirstTask;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FirstTaskTest {
    @Test
    public void testTrueIdentityCheck() {
        String [] source = "192.168.0.1".split("\\.");
        String [] target = "192.168.0.5".split("\\.");

        assertTrue(FirstTask.identityCheck(source, target));
    }

    @Test
    public void testFalseIdentityCheck() {
        String [] source = "192.168.0.1".split("\\.");
        String [] target = "192.168.1.5".split("\\.");

        assertFalse(FirstTask.identityCheck(source, target));
    }

    @Test
    public void testTrueValidateCheck() {
        String source = "192.168.0.1";
        String target = "192.168.1.5";

        assertTrue(FirstTask.validateCheck(source, target));
    }

    @Test
    public void testFalseValidateCheck() {
        String source = "Test address";
        String target = "192.168.1.5";

        assertFalse(FirstTask.validateCheck(source, target));
    }

}
