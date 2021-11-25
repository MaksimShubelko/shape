package by.task.shubelko.service;

import by.task.shubelko.entity.Ball;
import by.task.shubelko.exception.BallException;

public interface ShapeService {
    double calculateSurfaceArea(Ball ball);

    double calculateBallVolume(Ball ball);

    double calculatePartVolumeByPlaneParallelXY(Ball ball, double coordinateZ) throws BallException;

    double calculatePartVolumeByPlaneParallelXZ(Ball ball, double coordinateY) throws BallException;

    double calculatePartVolumeByPlaneParallelYZ(Ball ball, double coordinateX) throws BallException;

    boolean isBall(Ball ball);

    boolean isPlaneSwing(Ball ball);

}
