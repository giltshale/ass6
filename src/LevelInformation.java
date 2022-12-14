import biuoop.KeyboardSensor;
import java.util.List;

/**
 * interface that receives all level information .
 * The LevelInformation interface specifies the
 * information required to fully describe a level.
 * The classes should correspond to the
 * following layouts
 */
public interface LevelInformation {
    /**
     * balls for play.
     * @return int,numberOfBalls.
     */
    int numberOfBalls();


    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * The initial velocity of each ball.
     *
     * @return list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed.
     *
     * @return paddleSpeed, number.
     */
    int paddleSpeed();

    /**
     * paddleWidth.
     *
     * @return paddleWidth ,number.
     */
    int paddleWidth();

    /**
     *the level name will be displayed at the top of the screen.
     * @return String levelName.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *@return Sprite.
     */
    Sprite getBackground();


    /**
     * The Blocks that make up this level, each block contains.
     * its size, color and location.
     *
     * @return list of blocks.
     */
    List<Block> blocks();


    /**
     * Number of blocks that should be removed.
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return numberOfBlocksToRemove, number.
     */
    int numberOfBlocksToRemove();

    /**
     * create list of balls for play .
     * @param velocity speed of the balls.
     * @param gameEnvironment so the balls will know where to move.
     * @return  List<Ball>.
     */
    List<Ball> balls(List<Velocity> velocity, GameEnvironment gameEnvironment);

    /**
     * paddle.
     *
     * @param keyboardSensor keys to press .
     * @return paddle.
     */
    Paddle paddle(KeyboardSensor keyboardSensor);
}