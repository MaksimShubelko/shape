package by.task.shubelko.observer;

import by.task.shubelko.exception.BallException;

public interface BallObserver {
    void updateVolume(BallEvent ballEvent) throws BallException;

    void updateSurfaceArea(BallEvent ballEvent) throws BallException;
}
