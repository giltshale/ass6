import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.List;

/**
 * This class will be in charge of creating the different levels.
 * and moving from one level to the next.
 */
public class GameFlow {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private ScoreTrackingListener scoreTrackingListener;
    private Counter scoreCounter;
    private ScoreIndicator scoreIndicator;
    private AnimationRunner runner;
    private GUI gui;
    private Sleeper sleeper;

    /**
     * game flow constructor.
     */
    public GameFlow() {
        sleeper = new Sleeper();
        gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        runner = new AnimationRunner(gui, 60, sleeper);
        scoreCounter = new Counter();
        scoreTrackingListener = new ScoreTrackingListener(scoreCounter);
        scoreIndicator = new ScoreIndicator(scoreCounter, new Point(WIDTH / 2 - 50, 18));
        keyboardSensor = gui.getKeyboardSensor();
    }

    /**
     * running  and initializing each level at the time.
     *
     * @param levels game levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean lost = false;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, scoreTrackingListener,
                    scoreCounter, scoreIndicator, runner, gui);
            level.initialize();
            level.run();
            if (level.remainingBalls() == 0) {
                lost = true;
                break;
            }
        }
        runner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), "space", new EndScreen(
                scoreCounter, lost)));
        gui.close();
    }
}