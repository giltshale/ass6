import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class of level 2 of the game , ball direct hits the block.
 */
public class WideEasy implements LevelInformation {

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
    public WideEasy() {
        this.paddeleWidth = 600;
        this.paddleHeight = 10;
        this.paddleSpeed = 6;
        this.blockWidth = 51;
        this.blockHieght = 20;
        this.paddleStartingLocation = new Point(100, 550);
        this.blockStartingLocation = new Point(385, 200);
        this.ballStartingLocation = new Point((double) GameLevel.getWIDTH() / 2, paddeleWidth - blockWidth);
        this.ballRadius = 4;
        this.balleSpeed = 6;

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
        int angel = 12;
        for (int i = 0; i <= 4; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angel + i * 10, balleSpeed));
        }
        int angel1 = 262;
        for (int i = 5; i < 10; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angel1 + i * 10, balleSpeed));
        }

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
        return "Wide Easy";
    }

    /**
     * updating the Background.
     *
     * @return new Background for this level.
     */
    @Override
    public Sprite getBackground() {
        return new WideEasyBackground(new Rectangle(new Point(0, 0),
                GameLevel.getWIDTH(), GameLevel.getHEIGHT(), Color.white));
    }

    /**
     * creating List of blocks.
     *
     * @return list of blocks.
     */
    @Override
    // changing the colors
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        //choosing 7 different colors for the blocks
        Color[] colors = {Color.CYAN, Color.CYAN, Color.PINK,
                Color.PINK, Color.BLUE, Color.BLUE, Color.GREEN, Color.GREEN, Color.GREEN,
                Color.YELLOW, Color.YELLOW, Color.ORANGE, Color.ORANGE, Color.RED, Color.RED};
        //adding the blocks to the sprites
        for (int j = 0; j < 15; j++) {

            Block b = new Block(new Rectangle(new Point(730 - j * 51, 250), blockWidth, blockHieght, colors[j]));
            blocks.add(b);
            // b.addToGame(this);
            //  b.addHitListener(blockRemover);
            //  b.addHitListener(scoreTrackingListener);
            //  counterBlocks.increase(1);
        }

        //blocks.add(new Block(new Rectangle(new Point(375, 200), 50, 50, Color.RED)));
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
