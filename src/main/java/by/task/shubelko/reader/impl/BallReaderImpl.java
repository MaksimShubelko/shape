package by.task.shubelko.reader.impl;

import by.task.shubelko.exception.BallException;
import by.task.shubelko.reader.Reader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallReaderImpl implements Reader {
    public static final Logger logger = LogManager.getLogger();

    public List<String> readFile(String path) throws BallException {

        if (path == null || path.isEmpty()) {
            throw new BallException("Incorrect file path! " + path);
        }

        List<String> doubleStringList;
        Path dataFile = Paths.get(path);
        try (Stream<String> dataStream = Files.lines(dataFile)) {

            doubleStringList = dataStream
                    .collect(Collectors.toList());

            logger.log(Level.INFO, "Read file {} is successful", dataFile.getFileName());

        } catch (IOException e) {
            throw new BallException(String.format("Input error during reading file %s", dataFile.getFileName()), e);
        }

        return doubleStringList;
    }
}
