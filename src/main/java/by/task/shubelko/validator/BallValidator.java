package by.task.shubelko.validator;

import by.task.shubelko.entity.Ball;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BallValidator {
    public static final String BALL_DATA_REGEX = "([-]?\\d+\\.\\d+\\s+){3}([-]?\\d+\\.\\d+)";

    public static boolean isBallPossible(Ball ball) {
        double radius = ball.getRadius();
        return radius > 0;
    }

    public static boolean isBallData(String data) {
        return data.matches(BALL_DATA_REGEX);
    }
}
