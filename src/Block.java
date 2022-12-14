/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * block is some objects that  we collide into.
 * class, that can be either a block in the middle of the game, or a block in the edge of the screen.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle rectangle;

    /**
     * constructor of block.
     *
     * @param rectangle the shape of any block.
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        hitListeners = new ArrayList<>();
    }

    /**
     * block constructor.
     *
     * @param rectangle receive rectangle that we create .
     * @param green     choosing color for check
     */
    public Block(Rectangle rectangle, Color green) {
        this.rectangle = rectangle;
        hitListeners = new ArrayList<>();
    }

    /**
     * gets CollisionRectangle.
     *
     * @return the Rectangle
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with.
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param collisionPoint  the point of collision.
     * @param currentVelocity the speed that the ball have at any time.
     * @param hitter          receive the point where ball hits.
     * @return Velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // asking where the ball hits the block.
        String there = rectangle.whereIsTheHit(collisionPoint);
        double cuDX = currentVelocity.getDx();
        double cuDY = currentVelocity.getDy();
// changing direction for the ball with the same speed and keeping the last point .
        Velocity reversedVelocity = new Velocity(-1 * cuDX, -1 * cuDY);
        Point previousPoint = reversedVelocity.applyToPoint(collisionPoint);
        // making sure the ball is inside the block boundaries.
        boolean isInside = rectangle.pointInside(previousPoint);
//the speed that the ball have.
        Velocity returnedVelocity = new Velocity(cuDX, cuDY);
        // asking where the ball hits and changing the speed direction
        if (there.equals("LEFT") && (currentVelocity.getDx()
                >= 0 || (currentVelocity.getDx() <= 0 && isInside))) {
            returnedVelocity.setDx(cuDX * -1);
        } else if (there.equals("UP") && currentVelocity.getDy()
                >= 0 || (currentVelocity.getDy() <= 0 && isInside)) {
            returnedVelocity.setDy(cuDY * -1);
        } else if (there.equals("DOWN") && currentVelocity.getDy()
                <= 0 || (currentVelocity.getDy() >= 0 && isInside)) {
            returnedVelocity.setDy(cuDY * -1);
        } else if (there.equals("RIGHT") && currentVelocity.getDx()
                <= 0 || (currentVelocity.getDx() >= 0 && isInside)) {
            returnedVelocity.setDx(cuDX * -1);
        }

        this.notifyHit(hitter);

        // returning the speed to the correct direction.
        return returnedVelocity;
    }

    /**
     * drawing a rectangle.
     *
     * @param surface drawing shapes.
     */
    public void drawOn(DrawSurface surface) {
        rectangle.drawRectangle(surface);
        surface.setColor(Color.BLACK);
        //fixing the boundaries of the rectangle.
        surface.drawRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * .
     */
    public void timePassed() {
    }

    /**
     * adding sprites and collidables to the game.
     *
     * @param g receive from user.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * removeFromGame collidable and sprites.
     *
     * @param gameLevel updating game .
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * notifying  when Hit happens.
     *
     * @param hitter the hitting object.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * adding HitListener.
     *
     * @param hl hitlistenr
     */
    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * removing hit listener.
     *
     * @param hl hit listener.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
