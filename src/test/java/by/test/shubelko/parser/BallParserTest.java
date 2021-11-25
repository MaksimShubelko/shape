package by.test.shubelko.parser;

import by.task.shubelko.exception.BallException;
import by.task.shubelko.parser.Parser;
import by.task.shubelko.parser.impl.BallParser;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BallParserTest {

    @Test
    public void testParse() throws BallException {
        Parser parser = new BallParser();
        List<double[]> actualArray = new ArrayList<>();
        List<double[]> expectedArray = new ArrayList<>();
        actualArray = parser.parseStringListToArray(List.of("2.7 6.0 7.1 8.7"));
        expectedArray.add(new double[]{2.7, 6.0, 7.1, 8.7});
        assertEquals(actualArray.get(0), expectedArray.get(0), 0.001, "Test failed as...");
    }

}
