package by.task.shubelko.repository;

import by.task.shubelko.entity.Ball;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository {
    void addBall(Ball ball);

    void addAllBalls(Collection<Ball> ball);

    boolean removeBall(Ball ball);

    boolean removeAllBalls(Collection<Ball> ball);

    List<? super Ball> query(Specification specification);

    List<? super Ball> sort(Comparator<? super Ball> comparator);
}
