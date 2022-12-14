import biuoop.DrawSurface;

import java.awt.Color;

/**
 * LevelIndicator that lets me know witch level we play.
 */
public class LevelIndicator implements Sprite {
    private String name;

    /**
     * LevelIndicator so we can know what level are we.
     *
     * @param name level names .
     */
    public LevelIndicator(String name) {
        this.name = name;
    }


    /**
     * draw the sprite to the screen.
     *
     * @param d drawnig.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(550, 18, "Level Name: " + this.name, 18);
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
