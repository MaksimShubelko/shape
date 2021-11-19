package action;

import entity.Ball;
import entity.Point;

import java.util.OptionalDouble;

public interface ShapeCalculator {
    OptionalDouble calculateSurfaceArea(Ball ball);

    OptionalDouble calculateBallVolume(Ball ball);

    OptionalDouble calculatePartVolumeAboveXY(Ball ball);

    OptionalDouble calculatePartVolumeAboveXZ(Ball ball);

    OptionalDouble calculatePartVolumeAboveYZ(Ball ball);

    boolean isBall(Ball ball);

    boolean isPlaneSwing(Ball ball);

}
