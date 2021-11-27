package by.task.shubelko.reader;

import by.task.shubelko.exception.BallException;

import java.net.URISyntaxException;
import java.util.List;

public interface Reader {
    List<String> readFile(String path) throws BallException, URISyntaxException;
}
