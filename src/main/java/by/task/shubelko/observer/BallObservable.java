package by.task.shubelko.observer;

import by.task.shubelko.exception.BallException;

public interface BallObservable<T extends BallObserver> {
    void attach(T observer);

    void detach(T observer);

    void notifyObservers() throws BallException;
}
