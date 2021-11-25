package by.task.shubelko.parser;

import by.task.shubelko.exception.BallException;

import java.util.List;

public interface Parser {
    List<double[]> parseStringListToArray(List<String> stringList) throws BallException;
}
