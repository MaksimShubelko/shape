package by.task.shubelko.repository;

import by.task.shubelko.entity.Ball;

@FunctionalInterface
public interface Specification {
    boolean specify(Ball ball);
}
