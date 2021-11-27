package by.task.shubelko.filler;

import by.task.shubelko.creator.BallCreator;
import by.task.shubelko.entity.Ball;
import by.task.shubelko.entity.Point;
import by.task.shubelko.exception.BallException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.task.shubelko.repository.Repository;
import by.task.shubelko.repository.impl.BallRepositoryImpl;

public class RepositoryFiller {
    private static final Logger logger = LogManager.getLogger();
    private static final BallCreator ballCreator = new BallCreator();

    public void fillBallRepository(double[] array) throws BallException {
        Ball ball = ballCreator.createBall(array);
        Repository repository = BallRepositoryImpl.getInstance();
        repository.add(ball);
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillBallWarehouse(ball);
        logger.log(Level.INFO, "add ball " + ball + " to repository");
    }

    public void fillBallRepository(Point center, double radius) throws BallException {
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(center, radius);
        BallRepositoryImpl repository = BallRepositoryImpl.getInstance();
        repository.add(ball);
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillBallWarehouse(ball);
        logger.log(Level.INFO, "add ball " + ball + " to repository");
    }

    public void fillBallRepository(double coordinateX, double coordinateY, double coordinateZ, double radius) throws BallException {
        BallCreator ballCreator = new BallCreator();
        Ball ball = ballCreator.createBall(coordinateX, coordinateY, coordinateZ, radius);
        BallRepositoryImpl repository = BallRepositoryImpl.getInstance();
        repository.add(ball);
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillBallWarehouse(ball);
        logger.log(Level.INFO, "add ball " + ball + " to repository");
    }
}