package by.task.shubelko.observer.impl;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.entity.BallParameters;
import by.task.shubelko.entity.Warehouse;
import by.task.shubelko.exception.BallException;
import by.task.shubelko.observer.BallEvent;
import by.task.shubelko.observer.BallObserver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.task.shubelko.service.impl.BallServiceImpl;

public class BallObserverImpl implements BallObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateVolume(BallEvent ballEvent) throws BallException {
        Ball ball = ballEvent.getSource();
        long id = ball.getBallId();
        Warehouse warehouse = Warehouse.getInstance();
        BallParameters parameters = warehouse.get(id);
        BallServiceImpl calculation = new BallServiceImpl();
        double volume = calculation.calculateBallVolume(ball);
        parameters.setVolume(volume);
        logger.log(Level.INFO, "update volume in ball " + ball);
    }

    @Override
    public void updateSurfaceArea(BallEvent ballEvent) throws BallException {
        Ball ball = ballEvent.getSource();
        long id = ball.getBallId();
        Warehouse warehouse = Warehouse.getInstance();
        BallParameters parameters = warehouse.get(id);
        BallServiceImpl calculation = new BallServiceImpl();
        double surfaceArea = calculation.calculateSurfaceArea(ball);
        parameters.setSurfaceArea(surfaceArea);
        logger.log(Level.INFO, "update surface area in ball " + ball);
    }
}
