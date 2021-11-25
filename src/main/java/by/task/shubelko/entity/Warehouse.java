package by.task.shubelko.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Long, BallParameters> ballMap;


    private Warehouse() {
        this.ballMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public BallParameters put(Long ballId, BallParameters parameters) {
        return ballMap.put(ballId, parameters);
    }

    public BallParameters remove(Long ballId) {
        return ballMap.remove(ballId);
    }

    public BallParameters get(Long ballId) {
        BallParameters parameters = ballMap.get(ballId);
        if (parameters == null) {
            logger.log(Level.ERROR, "There are no such element by id " + ballId);
        }
        return parameters;
    }
}
