package action.impl;

import action.ShapeCalculator;
import entity.Ball;
import entity.Point;

import java.util.OptionalDouble;

public class BallCalculatorImpl implements ShapeCalculator {

    @Override
    public OptionalDouble calculateSurfaceArea(Ball ball) {
        return OptionalDouble.of(4 * Math.pow(ball.getRadius(), 2) * Math.PI);
    }

    @Override
    public OptionalDouble calculateBallVolume(Ball ball) {
        return OptionalDouble.of(4 * Math.pow(ball.getRadius(), 3) * Math.PI / 3);
    }

    @Override
    public OptionalDouble calculatePartVolumeAboveXY(Ball ball) {
        Point point = ball.getCentrePoint();
        OptionalDouble totalVolume = calculateBallVolume(ball);

        if (Math.abs(point.getCoordinateX()) > ball.getRadius()) {
            return OptionalDouble.of(0);
        }

        double height = Math.abs(point.getCoordinateX());
        double volumeBelowXY = Math.PI * Math.pow(height, 2) * (ball.getRadius() - height / 3);
        return OptionalDouble.of((totalVolume.getAsDouble() - volumeBelowXY) / volumeBelowXY);
    }

    @Override
    public OptionalDouble calculatePartVolumeAboveXZ(Ball ball) {
        Point point = ball.getCentrePoint();
        OptionalDouble totalVolume = calculateBallVolume(ball);

        if (Math.abs(point.getCoordinateY()) > ball.getRadius()) {
            return OptionalDouble.of(0);
        }

        double height = Math.abs(point.getCoordinateY());
        double volumeBelowXZ = Math.PI * Math.pow(height, 2) * (ball.getRadius() - height / 3);
        return OptionalDouble.of((totalVolume.getAsDouble() - volumeBelowXZ) / volumeBelowXZ);
    }

    @Override
    public OptionalDouble calculatePartVolumeAboveYZ(Ball ball) {
        Point point = ball.getCentrePoint();
        OptionalDouble totalVolume = calculateBallVolume(ball);

        if (Math.abs(point.getCoordinateX()) > ball.getRadius()) {
            return OptionalDouble.of(0);
        }

        double height = Math.abs(point.getCoordinateX());
        double volumeBelowYZ = Math.PI * Math.pow(height, 2) * (ball.getRadius() - height / 3);
        return OptionalDouble.of((totalVolume.getAsDouble() - volumeBelowYZ) / volumeBelowYZ);
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
