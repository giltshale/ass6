import biuoop.DrawSurface;

import java.awt.Color;

/**
 * DirectHitBackground is a class the.
 * extends background so i can add drawings on the background.
 */
public class DirectHitBackground extends BackGround {
    /**
     * constructor DirectHitBackground.
     *
     * @param rectangle rectangle.
     */
    public DirectHitBackground(Rectangle rectangle) {
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
        d.setColor(Color.blue);
        d.drawCircle(400, 215, 50);
        d.drawCircle(400, 215, 70);
        d.drawCircle(400, 215, 90);
        d.drawLine(400, 190, 400, 110);
        d.drawLine(400, 240, 400, 330);
        d.drawLine(380, 215, 280, 215);
        d.drawLine(420, 215, 520, 215);
    }
}
