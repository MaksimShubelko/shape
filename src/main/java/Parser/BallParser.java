package Parser;

import exception.BallException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.BallValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_DELIMITER_REGEX = "\\s+";

    public List<double[]> parseStringListToArray(List<String> doubleStringList) throws BallException {
        if (Optional.ofNullable(doubleStringList).isPresent()) {
            throw new BallException("List is null or hasn't any strings");
        }

        List<double[]> doubleArraysList;

        doubleArraysList = doubleStringList.stream()
                .map(String::trim)
                .filter(BallValidator::isBallData)
                .peek(line -> logger.log(Level.DEBUG, "{} added", line))
                .map(line -> line.split(SPACE_DELIMITER_REGEX))
                .map(array -> Stream.of(array)
                        .mapToDouble(Double::parseDouble)
                        .toArray())
                .collect(Collectors.toList());

        logger.log(Level.INFO, "Parsing is successful");

        return doubleArraysList;
    }
}
