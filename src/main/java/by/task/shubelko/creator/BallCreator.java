package by.task.shubelko.creator;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.entity.Point;
import by.task.shubelko.exception.BallException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallCreator {
    private static final Logger logger = LogManager.getLogger();
    private static final int VALID_AMOUNT_OF_PARAMS = 4;

    public List<Ball> createBallsList(List<double[]> doubleArraysList) throws BallException {
        List<Ball> triangleArrayList = new ArrayList<>();

        if (doubleArraysList == null || doubleArraysList.isEmpty()) {
            throw new BallException("Given list is null or hasn't any arrays");
        }

        for (double[] coordinateArray : doubleArraysList) {
            Ball ball = createBall(coordinateArray);
            triangleArrayList.add(ball);
        }

        logger.log(Level.INFO, "Creating ball list is successful");

        return triangleArrayList;
    }

    public Ball createBall(double[] paramsArray) throws BallException {
        if (paramsArray == null || paramsArray.length != VALID_AMOUNT_OF_PARAMS) {
            throw new BallException(String.format("Parameters %s aren't correct", Arrays.toString(paramsArray)));
        }

        var ball = new Ball(new Point(paramsArray[0], paramsArray[1], paramsArray[2]),
                paramsArray[3]);

        logger.log(Level.INFO, "Creating Ball is successful");

        return ball;
    }

    public Ball createBall(double coordinateX, double coordinateY, double coordinateZ, double radius) throws BallException {
        return createBall(new double[]{coordinateX, coordinateY, coordinateZ, radius});
    }

    public Ball createBall(Point point, double radius) throws BallException {
        return createBall(new double[]{point.getCoordinateX(), point.getCoordinateY(), point.getCoordinateZ(), radius});
    }


}
