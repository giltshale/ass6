import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * * takes an Animation object and runs it.
 * * Now,we implement the task-specific information in the Animation object,
 * * and run it using the loop in the AnimationRunner class
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSeconds;
    private Sleeper sleeper;

    /**
     * constructor of  AnimationRunner.
     *
     * @param gui             the library.
     * @param framesPerSecond frame count.
     * @param sleeper         so we can see.
     */
    public AnimationRunner(GUI gui, int framesPerSecond, Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSeconds = framesPerSecond;
        this.sleeper = sleeper;
    }

    /**
     * running the animation we get.
     *
     * @param animation that we get for running.
     */
    public void run(Animation animation) {
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}