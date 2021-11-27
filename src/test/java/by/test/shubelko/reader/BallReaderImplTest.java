package by.test.shubelko.reader;

import by.task.shubelko.exception.BallException;
import by.task.shubelko.reader.Reader;
import by.task.shubelko.reader.impl.BallReaderImpl;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BallReaderImplTest {
    @Test
    public void testReadFromFile() throws BallException, URISyntaxException {
        Reader reader = new BallReaderImpl();
        //путь из test source root не работает даже после пересоздания
        List<String> actualArray = reader.readFile("src/test/resources/data/testData.txt");
        List<String> expectedArray = new ArrayList<>();
        expectedArray.add("1 2 3 4");
        expectedArray.add("1.0 1.1 1.2 1.3");
        expectedArray.add("-1 -1 -1 1");
        assertEquals(actualArray, expectedArray, "Test failed as...");
    }

    @Test(expectedExceptions = BallException.class)
    public void testReadFromFileException() throws BallException, URISyntaxException {
        Reader reader = new BallReaderImpl();
        List<String> actualArray = reader.readFile("path.txt");
    }
}
