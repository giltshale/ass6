import biuoop.DrawSurface;

/**
 * class that helps the player to pause the game.
 * by pressing "p" key on keyboard.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * the text that will apear for the player on.
     * screen whet hits the "p" key on keyboard.
     *
     * @param d draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * stoping.
     *
     * @return stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}