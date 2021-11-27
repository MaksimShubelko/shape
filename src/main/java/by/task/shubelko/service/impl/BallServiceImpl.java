package by.task.shubelko.service.impl;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.entity.Point;
import by.task.shubelko.exception.BallException;
import by.task.shubelko.service.ShapeService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallServiceImpl implements ShapeService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public double calculateSurfaceArea(Ball ball) {
        double ballSurfaceArea = 4 * Math.pow(ball.getRadius(), 2) * Math.PI;
        logger.log(Level.INFO, "Calculation ball surface area is successful: ball = {}, surface area = {}", ball, ballSurfaceArea);
        return ballSurfaceArea;
    }

    @Override
    public double calculateBallVolume(Ball ball) {
        double ballVolume = 4 * Math.pow(ball.getRadius(), 3) * Math.PI / 3;
        logger.log(Level.INFO, "Calculation ball volume is successful: ball = {}, volume = {}", ball, ballVolume);
        return ballVolume;
    }

    @Override
    public double calculatePartVolumeByPlaneParallelXY(Ball ball, double coordinateZ) throws BallException {
        Point point = ball.getCentrePoint();
        double totalVolume = calculateBallVolume(ball);

        if (point.getCoordinateZ() + ball.getRadius() < coordinateZ ||
                point.getCoordinateZ() - ball.getRadius() > coordinateZ) {
            logger.log(Level.ERROR, "Incorrect coordinate Z of plane {} for ball {}", coordinateZ, ball);
            throw new BallException("Incorrect input data in method: coordinate Z of plane couldn't be " + coordinateZ);
        }

        double height = Math.abs(point.getCoordinateZ());
        double volumeBelowPlane = Math.PI * Math.pow(height, 2) * (ball.getRadius() - height / 3);
        return (totalVolume - volumeBelowPlane) / volumeBelowPlane;
    }

    @Override
    public double calculatePartVolumeByPlaneParallelXZ(Ball ball, double coordinateY) throws BallException {
        Point point = ball.getCentrePoint();
        double totalVolume = calculateBallVolume(ball);

        if (point.getCoordinateY() + ball.getRadius() < coordinateY ||
                point.getCoordinateY() - ball.getRadius() > coordinateY) {
            logger.log(Level.ERROR, "Incorrect coordinate Y of plane {} for ball {}", coordinateY, ball);
            throw new BallException("Incorrect input data in method: coordinate  of plane couldn't be " + coordinateY);
        }

        double height = Math.abs(point.getCoordinateY());
        double volumeBelowPlane = Math.PI * Math.pow(height, 2) * (ball.getRadius() - height / 3);
        logger.log(Level.ERROR, "Calculation ball volume is successful");
        return (totalVolume - volumeBelowPlane) / volumeBelowPlane;
    }

    @Override
    public double calculatePartVolumeByPlaneParallelYZ(Ball ball, double coordinateX) throws BallException {
        Point point = ball.getCentrePoint();
        double totalVolume = calculateBallVolume(ball);

        if (point.getCoordinateX() + ball.getRadius() < coordinateX ||
                point.getCoordinateX() - ball.getRadius() > coordinateX) {
            logger.log(Level.ERROR, "Incorrect coordinate X of plane {} for ball {}", coordinateX, ball);
            throw new BallException("Incorrect input data in method: coordinate X of plane couldn't be " + coordinateX);
        }

        double height = Math.abs(point.getCoordinateX());
        double volumeBelowPlane = Math.PI * Math.pow(height, 2) * (ball.getRadius() - height / 3);
        return (totalVolume - volumeBelowPlane) / volumeBelowPlane;
    }

    @Override
    public boolean isBall(Ball ball) {
        return ball.getRadius() > 0;
    }

    @Override
    public boolean isPlaneSwing(Ball ball) {
        Point point = ball.getCentrePoint();
        return point.getCoordinateX() == 0 || point.getCoordinateY() == 0 || point.getCoordinateZ() == 0;
    }
}
