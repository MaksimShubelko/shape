package creator;

import entity.Ball;
import entity.Point;
import exception.BallException;
import lombok.var;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallCreator {
    private static final Logger logger = LogManager.getLogger();
    private static final int VALID_AMOUNT_OF_PARAMS = 5;

    public List<Ball> createTriangleList(List<double[]> doubleArraysList) throws BallException {
        List<Ball> triangleArrayList = new ArrayList<>();

        if (doubleArraysList == null || doubleArraysList.isEmpty()) {
            throw new BallException("Given list is null or hasn't any arrays");
        }

        for (double[] coordinateArray : doubleArraysList) {
            Ball ball = createBall(coordinateArray);
            triangleArrayList.add(ball);
        }

        logger.log(Level.INFO, "Creating Triangle list is successful");

        return triangleArrayList;
    }

    public Ball createBall(double[] paramsArray) throws BallException {
        if (paramsArray == null || paramsArray.length != VALID_AMOUNT_OF_PARAMS) {
            throw new BallException(String.format("Parameters %s aren't correct", Arrays.toString(paramsArray)));
        }

        var ball = new Ball(new Point(paramsArray[0], paramsArray[1], paramsArray[2]),
                paramsArray[3]);

        logger.log(Level.INFO, "Creating Triangle is successful");

        return ball;
    }
}
