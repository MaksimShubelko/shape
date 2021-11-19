package reader;

import exception.BallException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallReader {
    public static final Logger logger = LogManager.getLogger();

    public List<String> readFile(String path) throws BallException {

        if (!Optional.ofNullable(path).isPresent()) {
            throw new BallException("Incorrect file path!");
        }

        List<String> doubleStringList;
        Path dataFile = Paths.get(path);

        try (Stream<String> dataStream = Files.lines(dataFile)){

            doubleStringList = dataStream
                    .collect(Collectors.toList());

            logger.log(Level.INFO, "Read file {} is successful", dataFile.getFileName());

        } catch (IOException e) {
            throw new BallException(String.format("Input error during reading file %s", dataFile.getFileName()), e);
        }

        return doubleStringList;
    }
}
