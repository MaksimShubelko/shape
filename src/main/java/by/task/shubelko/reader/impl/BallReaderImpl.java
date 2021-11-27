package by.task.shubelko.reader.impl;

import by.task.shubelko.exception.BallException;
import by.task.shubelko.reader.Reader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallReaderImpl implements Reader {
    public static final Logger logger = LogManager.getLogger();

    public List<String> readFile(String path) throws BallException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        classLoader.getResourceAsStream(path);
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new BallException("file not found! " + path);
        }
        File file = new File(resource.toURI());
        List<String> doubleStringList;
        try (Stream<String> dataStream = Files.lines(file.toPath(), StandardCharsets.UTF_8)) {
            doubleStringList = dataStream
                    .collect(Collectors.toList());

            logger.log(Level.INFO, "Read file {} is successful", file.getName());

        } catch (IOException e) {
            throw new BallException(String.format("Input error during reading file %s", file.getName()), e);
        }

        return doubleStringList;
    }
}
