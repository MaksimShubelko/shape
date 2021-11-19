package exception;

public class BallException extends Exception {
    public BallException() {
        super();
    }

    public BallException(String message) {
        super(message);
    }

    public BallException(String message, Throwable cause) {
        super(message, cause);
    }

    public BallException(Throwable cause) {
        super(cause);
    }
}
