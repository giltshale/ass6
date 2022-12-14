
import biuoop.DrawSurface;

/**
 * class that will help knowing score status.
 * which will be in charge of displaying the current score.
 * The ScoreIndicator will hold a reference to the scores counter
 * and will be added to the game as a sprite positioned at the top of the screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;
    private Point location;

    /**
     * constructor of scoring.
     *
     * @param scoreCounter receiving the score until this point.
     * @param location     receiving point location of the ball.
     */
    public ScoreIndicator(Counter scoreCounter, Point location) {
        this.scoreCounter = scoreCounter;
        this.location = location;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d drawnig.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText((int) location.getX(), (int) location.getY(), "Score: " + scoreCounter.getValue(), 18);

    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * adding itself to the game.
     *
     * @param g adding to the game
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
