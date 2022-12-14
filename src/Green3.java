import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class of level 3 of the game , ball direct hits the block.
 */
public class Green3 implements LevelInformation {

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
    private int startingHieght;
    private int startingWidth;

    /**
     * constructor that receive most boundries  and amount of paddle,ball and block.
     */
    public Green3() {
        this.paddeleWidth = 100;
        this.paddleHeight = 10;
        this.paddleSpeed = 6;
        this.blockWidth = 50;
        this.blockHieght = 20;
        this.paddleStartingLocation = new Point(375, 550);
        this.blockStartingLocation = new Point(385, 200);
        this.ballStartingLocation = new Point(375 + ((double) paddleWidth() / 2), 550 - 4);
        this.ballRadius = 4;
        this.balleSpeed = 5;
        this.startingHieght = 150;
        this.startingWidth = 280;

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
        velocities.add(Velocity.fromAngleAndSpeed(305, balleSpeed));
        velocities.add(Velocity.fromAngleAndSpeed(55, balleSpeed));
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
     * @return string of  levels Name.
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /**
     * updating the Background.
     *
     * @return new Background for this level.
     */
    @Override
    public Sprite getBackground() {
        return new Green3background(new Rectangle(new Point(0, 0),
                GameLevel.getWIDTH(), GameLevel.getHEIGHT(), new Color(42, 130, 21)));
    }

    /**
     * creating List of blocks.
     *
     * @return list of blocks.
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        //the width of the paddle
        //choosing 6 different colors for the blocks
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
        int rowCounter = 0;
        //adding the blocks to the sprites
        for (int j = startingHieght; j < startingHieght + (5 * blockHieght); j += blockHieght) {
            for (int i = startingWidth + (rowCounter * blockWidth); i <= 730; i += blockWidth) {
                Block b = new Block(new Rectangle(new Point(i, j), blockWidth, blockHieght, colors[rowCounter]));
                blocks.add(b);
            }
            rowCounter++;
        }
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
        List<Ball> balls;
        balls = new ArrayList<>();
        for (Velocity v : initialBallVelocities()) {
            balls.add(new Ball(ballStartingLocation, ballRadius, Color.WHITE, v, gameEnvironment));
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
        return new Paddle(keyboardSensor, new Rectangle(paddleStartingLocation, paddleWidth(),
                paddleHeight, Color.YELLOW), paddleSpeed);
    }
}
