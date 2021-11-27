package by.task.shubelko.repository;

import by.task.shubelko.entity.Ball;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository {
    void add(Ball ball);

    void addAll(Collection<Ball> ball);

    boolean remove(Ball ball);

    boolean removeAll(Collection<Ball> ball);

    List<? super Ball> query(Specification specification);

    List<? super Ball> sort(Comparator<? super Ball> comparator);
}
