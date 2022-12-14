/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;

/**
 * class that will hold the sprites and the collidables.
 * and will be in charge of the animation
 */
public class GameLevel implements Animation {

    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private Counter counterBlocks;
    private Counter counterBalls;
    private ScoreTrackingListener scoreTrackingListener;
    private Counter scoreCounter;
    private ScoreIndicator scoreIndicator;
    private LevelInformation levelInformation;
    private LevelIndicator levelIndicator;


    /**
     * /**
     * constructor of game.
     * making new sprites,environment,sleeper ang gui.
     *
     * @param levelInformation1      levelInformation1.
     * @param scoreTrackingListener1 scoreTrackingListener1.
     * @param scoreCounter1          scoreCounter1.
     * @param scoreIndicator1        scoreIndicator1.
     * @param runner1                runner1.
     * @param gui1                   gui1.
     */
    public GameLevel(LevelInformation levelInformation1, ScoreTrackingListener scoreTrackingListener1,
                     Counter scoreCounter1, ScoreIndicator scoreIndicator1, AnimationRunner runner1, GUI gui1) {
        scoreTrackingListener = scoreTrackingListener1;
        scoreCounter = scoreCounter1;
        scoreIndicator = scoreIndicator1;
        runner = runner1;
        gui = gui1;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        levelInformation = levelInformation1;
        counterBlocks = new Counter(levelInformation1.numberOfBlocksToRemove());
        counterBalls = new Counter(levelInformation1.numberOfBalls());
        blockRemover = new BlockRemover(this, counterBlocks);
        ballRemover = new BallRemover(this, counterBalls);
        this.levelIndicator = new LevelIndicator(levelInformation.levelName());
    }

    /**
     * setter of sprites.
     *
     * @return Spritecollection of sprutes
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * getter of GameEnvironment.
     *
     * @return the GameEnvironment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * getter of width.
     *
     * @return width of the GameEnvironment.
     */
    public static int getWIDTH() {
        return GameFlow.WIDTH;
    }

    /**
     * getter of height.
     *
     * @return height of the GameEnvironment.
     */
    public static int getHEIGHT() {
        return GameFlow.HEIGHT;
    }

    /**
     * adding Collidables to the game environment.
     *
     * @param c collidable that receive from user
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * adding sprites to the game environment.
     *
     * @param s sprites  that receive from user.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle).
     * and add them to the game.
     */
    public void initialize() {
        levelInformation.getBackground().addToGame(this);


        //the size of the paddle
        int borderSize = 20;
        //placing the border blocks for all sides
        Block leftBlock = new Block(new Rectangle(new Point(0, 0), borderSize,
                GameFlow.HEIGHT, Color.GRAY));
        Block rightBlock = new Block(new Rectangle(new Point(GameFlow.WIDTH - borderSize,
                0), borderSize, GameFlow.HEIGHT, Color.GRAY));
        Block upperBlock = new Block(new Rectangle(new Point(0, borderSize), GameFlow.WIDTH,
                borderSize, Color.GRAY));
        Block downBlock = new Block(new Rectangle(new Point(0, GameFlow.HEIGHT), GameFlow.WIDTH,
                borderSize, Color.GRAY));
        Block scoreBlock = new Block(new Rectangle(new Point(0, 0), GameFlow.WIDTH,
                borderSize, Color.WHITE));

        for (Block block : levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
        }

        downBlock.addHitListener(ballRemover);
        //adding the blocks the sprites
        leftBlock.addToGame(this);
        rightBlock.addToGame(this);
        upperBlock.addToGame(this);
        downBlock.addToGame(this);
        scoreBlock.addToGame(this);


        //creating the paddle
        Paddle paddle = levelInformation.paddle(gui.getKeyboardSensor());
        //adding the paddle to the sprites
        paddle.addToGame(this);
        scoreIndicator.addToGame(this);
        levelIndicator.addToGame(this);

    }

    /**
     * stop.
     *
     * @return stop.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * the logic from the previous run method goes here.
     * the `return` or `break` statements replaced with
     * this.running = false;
     * drawing the rectangle
     *
     * @param d draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;
        //drawing the rectangle
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (counterBalls.getValue() == 0) {
            running = false;
        } else if (counterBlocks.getValue() == 0) {
            running = false;
            scoreCounter.increase(100);
        }
        if (gui.getKeyboardSensor().isPressed("p")) {
            runner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "space", new PauseScreen()));
        }
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.runner.run(new CountdownAnimation(sprites)); // countdown before turn starts.
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * createBallsOnTopOfPaddle for star.
     */
    public void createBallsOnTopOfPaddle() {
        for (Ball ball : levelInformation.balls(levelInformation.initialBallVelocities(), environment)) {
            ball.addToGame(this);
        }
    }

    /**
     * removing collidable from game.
     *
     * @param c collidable.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * removing sprites from game.
     *
     * @param s sprites.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * checking how many balls i have left.
     *
     * @return remaining balls.
     */
    public int remainingBalls() {
        return this.counterBalls.getValue();
    }
}