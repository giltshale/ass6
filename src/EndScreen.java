import biuoop.DrawSurface;

/**
 * class for ending screen that lets the player know if the player win or loose .
 */
public class EndScreen implements Animation {
    private Counter score;
    private boolean stop;
    private boolean lost;

    /**
     * constructor.
     *
     * @param score the score player earned.
     * @param lost  if player is loosing the game.
     */
    public EndScreen(Counter score, boolean lost) {
        this.stop = false;
        this.score = score;
        this.lost = lost;
    }

    /**
     * printing game results.
     *
     * @param d draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        if (lost) {
            d.drawText(100, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), 50);
        } else {
            d.drawText(100, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 50);
        }
    }

    /**
     * letting know to stop.
     *
     * @return true if stops false if not.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}