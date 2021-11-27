package by.task.shubelko.repository.impl;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.repository.Specification;

public class RadiusSpecification implements Specification {
    private final double minRadius;
    private final double maxRadius;

    public RadiusSpecification(double minRadius, double maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Ball ball) {
        return (ball.getRadius() >= minRadius && ball.getRadius() <= maxRadius);
    }
}
