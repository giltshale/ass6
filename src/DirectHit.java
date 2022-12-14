import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class of level 1 of the game , ball direct hits the block.
 */
public class DirectHit implements LevelInformation {
    private int paddeleWidth;
    private int paddleSpeed;
    private Point ballStartingLocation;
    private int blockWidth;
    private int blockHieght;
    private Point blockStartingLocation;
    private int paddleHeight;
    private Point paddleStartingLocation;
    private int ballRadius;
    private int balleSpeed;

    /**
     * constructor that receive most boundries  and amount of paddle,ball and block.
     */
    public DirectHit() {
        this.paddeleWidth = 100;
        this.paddleHeight = 10;
        this.paddleSpeed = 6;
        this.balleSpeed = 6;
        this.blockWidth = 30;
        this.blockHieght = 30;
        this.ballRadius = 4;
        this.paddleStartingLocation = new Point(350, 550);
        this.blockStartingLocation = new Point(385, 200);
        this.ballStartingLocation = new Point((double) GameLevel.getWIDTH() / 2, 549);


    }

    /**
     * balls number.
     *
     * @return how many ball there is in the game.
     */
    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    /**
     * creating list of velocities.
     *
     * @return list of balls velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(0, balleSpeed));
        // new Velocity(5, 0)
        return velocities;
    }

    /**
     * paddleSpeed.
     *
     * @return speed number.
     */
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * paddleWidth.
     *
     * @return paddleWidth number.
     */
    @Override
    public int paddleWidth() {
        return this.paddeleWidth;
    }

    /**
     * levelName.
     *
     * @return first levels Name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * updating the Background.
     *
     * @return new Background for this level.
     */
    @Override
    public Sprite getBackground() {
        return new DirectHitBackground(new Rectangle(new Point(0, 0),
                GameLevel.getWIDTH(), GameLevel.getHEIGHT(), Color.BLACK));
    }

    /**
     * creating List of blocks.
     *
     * @return list of blocks.
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(this.blockStartingLocation, this.blockWidth, this.blockHieght, Color.RED)));
        return blocks;
    }

    /**
     * size of blocks.
     *
     * @return number Of Blocks To Remove
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    /**
     * creating list of balls adding the balls to it.
     *
     * @param velocity        list of velocities .
     * @param gameEnvironment gameEnvironment
     * @return list of balls.
     */
    @Override
    public List<Ball> balls(List<Velocity> velocity, GameEnvironment gameEnvironment) {
        List<Ball> balls = new ArrayList<>();
        for (Velocity v : initialBallVelocities()) {
            balls.add(new Ball(this.ballStartingLocation, ballRadius, Color.WHITE, v, gameEnvironment));
        }
        return balls;
    }

    /**
     * creating the paddle on the spot i want it.
     *
     * @param keyboardSensor so we can moove the paddle.
     * @return paddle.
     */
    @Override
    public Paddle paddle(KeyboardSensor keyboardSensor) {
        return new Paddle(keyboardSensor, new Rectangle(this.paddleStartingLocation, this.paddeleWidth,
                this.paddleHeight, Color.YELLOW), paddleSpeed);
    }
}
