import biuoop.DrawSurface;

import java.awt.Color;

/**
 * DirectHitBackground is a class the.
 * extends background so i can add drawings on the background.
 */
public class WideEasyBackground extends BackGround {
    /**
     * constructor DirectHitBackground.
     *
     * @param rectangle rectangle.
     */
    public WideEasyBackground(Rectangle rectangle) {
        super(rectangle);
    }

    /**
     * drawing the circles of 'sun'  the lines.
     *
     * @param d drawnig.
     */
    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(Color.orange);
        for (int i = 0; i <= 700; i += 10) {
            d.drawLine(100, 150, i, 250);
        }
        d.setColor(Color.orange);
        // d.drawCircle(100, 150, 40);
        d.fillCircle(100, 150, 50);
        d.setColor(new Color(241, 215, 59, 255));
        d.fillCircle(100, 150, 45);
        d.setColor(new Color(238, 209, 25, 255));
        d.fillCircle(100, 150, 40);

    }
}
