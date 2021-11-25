package by.task.shubelko.filler;

import by.task.shubelko.creator.BallCreator;
import by.task.shubelko.entity.Ball;
import by.task.shubelko.entity.BallParameters;
import by.task.shubelko.entity.Point;
import by.task.shubelko.entity.Warehouse;
import by.task.shubelko.exception.BallException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.task.shubelko.service.ShapeService;
import by.task.shubelko.service.impl.BallServiceImpl;

public class WarehouseFiller {
    private static final Logger logger = LogManager.getLogger();
    private static final BallCreator ballCreator = new BallCreator();

    public void fillBallWarehouse(Ball ball) {
        long id = ball.getBallId();
        ShapeService ballService = new BallServiceImpl();
        double surfaceArea = ballService.calculateSurfaceArea(ball);
        double volume = ballService.calculateBallVolume(ball);
        BallParameters parameters = new BallParameters(surfaceArea, volume);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, parameters);
        logger.log(Level.INFO, "add ball " + ball + " to warehouse");
    }

    public void fillBallWarehouse(double[] array) throws BallException {
        Ball ball = ballCreator.createBall(array);
        fillBallWarehouse(ball);
    }

    public void fillBallWarehouse(Point center, double radius) throws BallException {
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(center, radius);
        fillBallWarehouse(ball);
    }

    public void fillBallWarehouse(double coordinateX, double coordinateY, double coordinateZ, double radius) throws BallException {
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, radius);
        fillBallWarehouse(ball);
    }

}