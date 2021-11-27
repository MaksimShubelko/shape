package by.task.shubelko.repository.impl;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.repository.Specification;


public class IdSpecification implements Specification {
    private final long minId;
    private final long maxId;

    public IdSpecification(long minId, long maxId) {
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean specify(Ball ball) {
        return (ball.getBallId() >= minId && ball.getBallId() <= maxId);
    }
}

