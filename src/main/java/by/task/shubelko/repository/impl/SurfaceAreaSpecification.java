package by.task.shubelko.repository.impl;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.repository.Specification;
import by.task.shubelko.service.impl.BallServiceImpl;

public class SurfaceAreaSpecification implements Specification {
    private final double minSurfaceArea;
    private final double maxSurfaceArea;

    public SurfaceAreaSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Ball ball) {
        BallServiceImpl ballServiceImpl = new BallServiceImpl();
        double surfaceArea = ballServiceImpl.calculateSurfaceArea(ball);
        return (surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea);
    }
}