/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;

/**
 * interface of sprites who can drawon ,tell if time passed and add anyone who wants to the game.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d drawnig.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * adding itself to the game.
     *
     * @param g adding to the game
     */
    void addToGame(GameLevel g);
}