import org.junit.Test;
import org.work.test.SecondTaskClass.Phonebook;

public class SecondTaskTest {
    Phonebook testvalue = new Phonebook();

    @Test
    public void testFindValueError() {
        String str1 = "Его%";

        testvalue.findValue(str1);
    }

    @Test
    public void testFindShortValue() {
        String str1 = "Его";

        testvalue.findValue(str1);
    }
}
