import org.junit.Test;
import org.work.test.PhoneBook.Phonebook;

public class PhoneBookTaskTest {
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
