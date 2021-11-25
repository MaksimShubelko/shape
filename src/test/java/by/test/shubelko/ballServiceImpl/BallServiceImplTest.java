package by.test.shubelko.ballServiceImpl;

import by.task.shubelko.creator.BallCreator;
import by.task.shubelko.entity.Ball;
import by.task.shubelko.exception.BallException;
import by.task.shubelko.service.ShapeService;
import by.task.shubelko.service.impl.BallServiceImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallServiceImplTest {
    private static final double coordinateX = 4;
    private static final double coordinateY = 4;
    private static final double coordinateZ = 4;
    private static final double radius = 4;

    @Test
    public void testCalculateSurfaceArea() throws BallException {
        ShapeService calculation = new BallServiceImpl();
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, radius);
        double actualSurfaceArea = calculation.calculateSurfaceArea(ball);
        double expectedSurfaceArea = 64 * Math.PI;
        assertEquals(actualSurfaceArea, expectedSurfaceArea, 0.001, "Test failed as...");
    }

    @Test
    public void testCalculateBallVolume() throws BallException {
        ShapeService calculation = new BallServiceImpl();
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, radius);
        double actualVolume = calculation.calculateBallVolume(ball);
        double expectedVolume = 256 * Math.PI / 3;
        assertEquals(actualVolume, expectedVolume, 0.001, "Test failed as...");
    }

    @Test
    public void testCalculatePartVolumeByPlaneParallelXY() throws BallException {
        ShapeService calculation = new BallServiceImpl();
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, radius);
        double actualVolume = calculation.calculatePartVolumeByPlaneParallelXY(ball, 2);
        double expectedVolume = 1;
        assertEquals(actualVolume, expectedVolume, 0.001, "Test failed as...");
    }

    @Test
    public void testCalculatePartVolumeByPlaneParallelXZ() throws BallException {
        ShapeService calculation = new BallServiceImpl();
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, radius);
        double actualVolume = calculation.calculatePartVolumeByPlaneParallelXZ(ball, 2);
        double expectedVolume = 1;
        assertEquals(actualVolume, expectedVolume, 0.001, "Test failed as...");
    }

    @Test
    public void testCalculatePartVolumeByPlaneParallelYZ() throws BallException {
        ShapeService calculation = new BallServiceImpl();
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(4, 2, 4, 4);
        double actualVolume = calculation.calculatePartVolumeByPlaneParallelYZ(ball, 2);
        double expectedVolume = 1;
        assertEquals(actualVolume, expectedVolume, 0.001, "Test failed as...");
    }

    @Test
    public void testIsBall() throws BallException {
        ShapeService calculation = new BallServiceImpl();
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, 0);
        boolean actual = calculation.isBall(ball);
        assertFalse(actual, " Test failed as...");
    }

    @Test
    public void testIsPlaneSwing() throws BallException {
        ShapeService calculation = new BallServiceImpl();
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, radius);
        boolean actual = calculation.isPlaneSwing(ball);
        assertFalse(actual, " Test failed as...");
    }
}
