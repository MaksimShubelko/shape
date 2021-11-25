package by.task.shubelko.repository.impl;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.repository.Specification;


public class IdSpecification implements Specification {
    private long nameId;

    public IdSpecification(long nameId) {
        this.nameId = nameId;
    }

    @Override
    public boolean specify(Ball ball) {
        return ball.getBallId() == nameId;
    }
}

