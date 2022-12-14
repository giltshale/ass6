import biuoop.DrawSurface;

import java.awt.Color;

/**
 * DirectHitBackground is a class the.
 * extends background so i can add drawings on the background.
 */
public class Green3background extends BackGround {
    /**
     * constructor DirectHitBackground.
     *
     * @param rectangle rectangle.
     */
    public Green3background(Rectangle rectangle) {
        super(rectangle);
    }

    /**
     * drawing the circles around the block.
     *
     * @param d drawnig.
     */
    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(new Color(46, 42, 41));
        d.fillRectangle(50, 400, 100, 600);
        d.setColor(Color.white);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(55 + j * 20, 410 + i * 30, 10, 20);
            }
            d.setColor(new Color(62, 58, 57));
            d.fillRectangle(90, 190, 20, 140);
            d.setColor(new Color(62, 58, 57));
            d.fillRectangle(80, 320, 40, 80);
            d.setColor(Color.orange);
            d.fillCircle(100, 180, 20);
            d.setColor(Color.red);
            d.fillCircle(100, 180, 15);
            d.setColor(Color.white);
            d.fillCircle(100, 180, 10);
        }
    }
}
