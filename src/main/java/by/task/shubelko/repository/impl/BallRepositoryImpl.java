package by.task.shubelko.repository.impl;

import by.task.shubelko.entity.Ball;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.task.shubelko.repository.Repository;
import by.task.shubelko.repository.Specification;

import java.util.*;
import java.util.stream.Collectors;

public class BallRepositoryImpl implements Repository {
    private static final Logger logger = LogManager.getLogger();
    private static BallRepositoryImpl instance;
    private final List<Ball> balls;

    public BallRepositoryImpl() {
        balls = new ArrayList<>();
    }

    public static BallRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BallRepositoryImpl();
        }
        return instance;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public Ball get(int index) {
        return balls.get(index);
    }

    public int size() {
        return balls.size();
    }

    @Override
    public void addBall(Ball Ball) {
        balls.add(Ball);
        logger.log(Level.INFO, "New ball in repository: " + Ball);
    }

    @Override
    public void addAllBalls(Collection<Ball> Ball) {
        balls.addAll(Ball);
        logger.log(Level.INFO, "New balls in repository: " + Ball);
    }

    @Override
    public boolean removeBall(Ball Ball) {
        return balls.remove(Ball);
    }

    @Override
    public boolean removeAllBalls(Collection<Ball> Ball) {
        return balls.removeAll(Ball);
    }

    @Override
    public List<? super Ball> query(Specification specification) {
        List<Ball> result = balls.stream().filter(specification::specify).collect(Collectors.toList());
        logger.log(Level.INFO, "Query by specification " + specification + ": " + result);
        return result;
    }

    @Override
    public List sort(Comparator<? super Ball> comparator) {
        List<Ball> result = balls.stream().sorted(comparator).collect(Collectors.toList());
        logger.log(Level.INFO, "Sorted with comparator " + comparator + ": " + result);
        return result;
    }
}
