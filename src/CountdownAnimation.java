import biuoop.DrawSurface;

import java.awt.Color;

/**
 * counting 3 seconds before game starts.
 */
public class CountdownAnimation implements Animation {
    private boolean stop;
    private int frameCount;
    private int currentcount;
    private String str;
    private SpriteCollection sprite;

    /**
     * constructor of countdownAnimation.
     *
     * @param sprite receive sprite collection.
     */
    public CountdownAnimation(SpriteCollection sprite) {
        this.sprite = sprite;
        stop = false;
        frameCount = 0;
        currentcount = 3;
        str = "" + currentcount + "...";
    }

    /**
     * method that passes each frame in frames of 40.
     * counting 3..2..1..go.
     *
     * @param d draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        if (frameCount % 40 == 0 && frameCount != 0) {
            currentcount--;
            str = "" + currentcount + "...";
        }
        if (frameCount > 120) {
            str = "GO";
        }
        sprite.drawAllOn(d);
        d.setColor(Color.blue);
        d.drawText(300, d.getHeight() / 2, str, 100);
        if (frameCount == 140) {
            this.stop = true;
        }
        frameCount++;
    }

    /**
     * helps to know when to stop the countdown.
     *
     * @return stop when needed to stop.
     */
    public boolean shouldStop() {
        return stop;
    }
}