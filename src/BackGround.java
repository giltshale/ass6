import biuoop.DrawSurface;

/**
 * BackGround that implements sprite, class for changing BackGround each level.
 */
public class BackGround implements Sprite {
    private Rectangle rectangle;

    /**
     * using rectangle for drawing on screen.
     *
     * @param rectangle rectangle.
     */
    public BackGround(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * drawnig on screen rectangle.
     *
     * @param d drawnig.
     */
    @Override
    public void drawOn(DrawSurface d) {
        rectangle.drawRectangle(d);
    }

    @Override
    public void timePassed() {
    }

    /**
     * adding the sprites to game.
     *
     * @param g adding to the game
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
