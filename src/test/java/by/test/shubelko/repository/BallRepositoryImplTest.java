package by.test.shubelko.repository;

import by.task.shubelko.comparator.BallComparator;
import by.task.shubelko.entity.Ball;
import by.task.shubelko.entity.BallParameters;
import by.task.shubelko.entity.Point;
import by.task.shubelko.entity.Warehouse;
import by.task.shubelko.exception.BallException;
import by.task.shubelko.filler.RepositoryFiller;
import by.task.shubelko.filler.WarehouseFiller;
import by.task.shubelko.repository.Repository;
import by.task.shubelko.repository.impl.*;
import by.task.shubelko.service.impl.BallServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BallRepositoryImplTest {
    BallRepositoryImpl ballQueryRepository;
    BallRepositoryImpl ballSortRepository;
    List<Ball> queryBalls;
    List<Ball> sortBalls;
    BallServiceImpl ballServiceImpl;
    Warehouse warehouse;


    @BeforeClass
    public void setUp() throws BallException {
        ballServiceImpl = new BallServiceImpl();
        warehouse = Warehouse.getInstance();
        ballQueryRepository = new BallRepositoryImpl();

        queryBalls = List.of(
                new Ball(new Point(2.5, 3.4, 7.0), 4),
                new Ball(new Point(-3.8, 1.2, 3.5), 6),
                new Ball(new Point(0.0, 0.0, 0.5), 2),
                new Ball(new Point(-10, -12, 6.8), 6),
                new Ball(new Point(8.3, -15, -6.7), 1),
                new Ball(new Point(-3.0, -3, 7.1), 3),
                new Ball(new Point(1.0, 53, 67), 4),
                new Ball(new Point(1.0, 8.0, -1.5), 44),
                new Ball(new Point(9.0, 45.3, 1.7), 13),
                new Ball(new Point(3.2, 2.0, 6.2), 3),
                new Ball(new Point(-3.0, 7.0, -7.2), 4),
                new Ball(new Point(3.5, -20, 8.2), 7),
                new Ball(new Point(3.0, 8.0, 7.1), 1),
                new Ball(new Point(-15.83, 10.2, 61), 6),
                new Ball(new Point(-3.2, -4.8, 42), 9),
                new Ball(new Point(-5.0, -10.0, -0.2), 5)
        );
        ballQueryRepository.addAll(queryBalls);

        ballSortRepository = new BallRepositoryImpl();
        sortBalls = new ArrayList<>();
        Ball ball = new Ball(new Point(8.3, 17.5, 7.3), 3.1);
        sortBalls.add(new Ball(new Point(3.0, 8.0, 6.3), 5.4));
        sortBalls.add(new Ball(new Point(-10, -12, 5.3), 4.1));
        sortBalls.add(new Ball(new Point(-10, -7, 4.1), 3.1));
        sortBalls.add(new Ball(new Point(2.5, 3.4, 1.1), 2.5));
        sortBalls.add(new Ball(new Point(3.0, 8.0, 4.5), 1.1));
        sortBalls.add(ball);

        WarehouseFiller warehouseFiller = new WarehouseFiller();
        for (Ball balls : sortBalls) {
            warehouseFiller.fillBallWarehouse(balls);
        }

        ballSortRepository.addAll(sortBalls);
    }

    @Test
    public void testQueryId() throws BallException {
        long from = 1;
        long to = 2;

        List<Ball> actual = ballQueryRepository.query(new IdSpecification(from, to));

        assertEquals(actual.size(), 2);
    }

    @Test
    public void testQueryRadius() throws BallException {
        double from = 0.0;
        double to = 3.0;

        List<Ball> actual = ballQueryRepository.query(new RadiusSpecification(from, to));

        assertEquals(actual.size(), 5);
    }

    @Test
    public void testQuerySurfaceArea() throws BallException {
        double from = 0.0;
        double to = 200.0;

        List<Ball> actual = ballQueryRepository.query(new SurfaceAreaSpecification(from, to));

        assertEquals(actual.size(), 5);
    }

    @Test
    public void testQueryVolume() throws BallException {
        double from = 0.0;
        double to = 300.0;

        List<Ball> actual = ballQueryRepository.query(new VolumeSpecification(from, to));

        assertEquals(actual.size(), 8);
    }

    @Test
    public void testSortId() throws BallException {
        List<Ball> actual = ballSortRepository.sort(BallComparator.ID.getComparator());
        boolean isSorted = true;

        ListIterator<Ball> it = actual.listIterator();
        for (Ball item = it.next(); it.hasNext(); item = it.next()) {
            if (it.hasPrevious() && it.previous().getBallId().compareTo(it.next().getBallId()) > 0) {
                isSorted = false;
            }
        }

        assertTrue(isSorted);
    }

    @Test
    public void testSortRadius() throws BallException {
        List<Ball> actual = ballSortRepository.sort(BallComparator.RADIUS.getComparator());
        boolean isSorted = true;

        ListIterator<Ball> it = actual.listIterator();
        for (Ball item = it.next(); it.hasNext(); item = it.next()) {
            if (it.hasPrevious() && it.previous().getRadius() < it.next().getRadius()) {
                isSorted = false;
            }
        }

        assertTrue(isSorted);
    }

    @Test
    public void testSortVolume() throws BallException {
        List<Ball> actual = ballSortRepository.sort(BallComparator.VOLUME.getComparator());

        ballServiceImpl = new BallServiceImpl();
        boolean isSorted = true;

        ListIterator<Ball> it = actual.listIterator();
        for (Ball item = it.next(); it.hasNext(); item = it.next()) {
            if (it.hasPrevious() && ballServiceImpl.calculateBallVolume(it.previous())
                    < ballServiceImpl.calculateBallVolume(it.next())) {
                isSorted = false;
            }
        }

        assertTrue(isSorted);
    }
    @Test
    public void testSortSurfaceArea() throws BallException {
        List<Ball> actual = ballSortRepository.sort(BallComparator.AREA.getComparator());

        ballServiceImpl = new BallServiceImpl();
        boolean isSorted = true;

        ListIterator<Ball> it = actual.listIterator();
        for (Ball item = it.next(); it.hasNext(); item = it.next()) {
            if (it.hasPrevious() && ballServiceImpl.calculateSurfaceArea(it.previous())
                    < ballServiceImpl.calculateSurfaceArea(it.next())) {
                isSorted = false;
            }
        }

        assertTrue(isSorted);
    }

}