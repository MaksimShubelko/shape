package by.task.shubelko.repository.impl;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.repository.Specification;
import by.task.shubelko.service.impl.BallServiceImpl;

public class VolumeSpecification implements Specification {
    private final double minVolume;
    private final double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Ball ball) {
        BallServiceImpl ballServiceImpl = new BallServiceImpl();
        double volume = ballServiceImpl.calculateBallVolume(ball);
        return (volume >= minVolume && volume <= maxVolume);
    }
}