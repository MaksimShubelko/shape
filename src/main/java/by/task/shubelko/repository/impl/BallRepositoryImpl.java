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

    public List<Ball> getAll() {
        return Collections.unmodifiableList(balls);
    }

    public Ball get(int index) {
        return balls.get(index);
    }

    public int size() {
        return balls.size();
    }

    @Override
    public void add(Ball ball) {
        balls.add(ball);
        logger.log(Level.INFO, "New ball in repository: " + ball);
    }

    @Override
    public void addAll(Collection<Ball> balls) {
        this.balls.addAll(balls);
        logger.log(Level.INFO, "New balls in repository: " + balls);
    }

    @Override
    public boolean remove(Ball ball) {
        return balls.remove(ball);
    }

    @Override
    public boolean removeAll(Collection<Ball> ball) {
        return balls.removeAll(ball);
    }

    @Override
    public List<Ball> query(Specification specification) {
        List<Ball> result = balls.stream().filter(specification::specify).collect(Collectors.toList());
        logger.log(Level.INFO, "Query by specification " + specification + ": " + result);
        return result;
    }

    @Override
    public List<Ball> sort(Comparator<? super Ball> comparator) {
        List<Ball> result = balls.stream().sorted(comparator).collect(Collectors.toList());
        logger.log(Level.INFO, "Sorted with comparator " + comparator + " : " + result);
        return result;
    }
}
