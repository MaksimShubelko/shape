package by.task.shubelko.comparator;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.entity.Warehouse;
import by.task.shubelko.exception.BallException;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.nullsLast;

public enum BallComparator {
    ID,
    RADIUS,
    AREA,
    VOLUME;

    public Comparator<Ball> getComparator() throws BallException {
        return switch (this) {
            case ID -> nullsLast(Comparator.comparingLong(Ball::getBallId));
            case RADIUS -> nullsLast(Comparator.comparingDouble(Ball::getRadius));
            case AREA -> nullsLast(comparingDouble((ToDoubleFunction<Ball>) ball ->
                    Warehouse.getInstance()
                            .get(ball.getBallId())
                            .getSurfaceArea()));
            case VOLUME -> nullsLast(comparingDouble((ToDoubleFunction<Ball>) ball ->
                    Warehouse.getInstance()
                            .get(ball.getBallId())
                            .getVolume()));
            default -> throw new BallException(String.format("%s comparator is absent", this.name()));
        };
    }
}