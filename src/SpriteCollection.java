/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * a SpriteCollection class will hold a collection of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * constructor of SpriteCollection.
     */
    public SpriteCollection() {
        sprites = new ArrayList<Sprite>();
    }

    /**
     * adding sprites s.
     *
     * @param s given sprite.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> tempSprites = new ArrayList<>(sprites);
        for (Sprite s : tempSprites) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d given drawOn.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }

    }

    /**
     * removing sprites.
     *
     * @param s received sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }
}