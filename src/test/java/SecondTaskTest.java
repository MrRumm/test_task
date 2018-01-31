import org.junit.Test;
import org.work.test.SecondTask;

public class SecondTaskTest {

    @Test
    public void testFindValue() {
        String str1 = "Его%";

        SecondTask.findValue(str1);
    }
}
