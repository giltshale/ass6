/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Our Rectangles will all be aligned with the axes.
 * In the intersectionPoints method we  return a List.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int moovingSpeed;

    /**
     * paddle constructor.
     *
     * @param keyboard     user input for movment (right or left)
     * @param rectangle    create the paddle from rectangle
     * @param moovingSpeed speed of the moovment we decide.
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rectangle, int moovingSpeed) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.moovingSpeed = moovingSpeed;
    }


    /**
     * mooving the paddle left side until the edge of the game screen.
     */
    public void moveLeft() {
        rectangle.setUpperLeft(new Point(rectangle.getUpperLeft().getX()
                - moovingSpeed, rectangle.getUpperLeft().getY()));
        if (rectangle.getUpperLeft().getX() <= 20) {
            rectangle.setUpperLeft(new Point(20, rectangle.getUpperLeft().getY()));
        }
    }

    /**
     * mooving the paddle right side until the edge of the game screen.
     */
    public void moveRight() {
        rectangle.setUpperLeft(new Point(rectangle.getUpperLeft().getX()
                + moovingSpeed, rectangle.getUpperLeft().getY()));
        if (rectangle.getUpperLeft().getX() + rectangle.getWidth() >= 780) {
            rectangle.setUpperLeft(new Point(780 - rectangle.getWidth(), rectangle.getUpperLeft().getY()));
        }
    }

    /**
     * Sprite tells where to move.
     */
    public void timePassed() {

        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the rectangle On screen.
     *
     * @param d drawnig.
     */
    public void drawOn(DrawSurface d) {
        rectangle.drawRectangle(d);
        d.setColor(Color.BLACK);
        //rectangle boundaries
        d.drawRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * Collidable who who knows how to get Collision point of Rectangle.
     *
     * @return rectangle that collides
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * finding the collision point, knowing the speed and angel.
     * of hit and returning new angel with the same speed that i had .
     * we divide the screen into 5 parts and every part returns different angel of speed.
     *
     * @param collisionPoint  gets the collisionPoint.
     * @param currentVelocity gets the current speed of ball.
     * @param hitter          ball hitter.
     * @return same Velocity that the ball had when it hits but different angel of speed
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double startingPointX = rectangle.getUpperLeft().getX();
        double fifth = rectangle.getWidth() / 5;
        // x coordinate of collision
        double collisionX = collisionPoint.getX();
        double xSpeed = Math.pow(currentVelocity.getDx(), 2);
        double ySpeed = Math.pow(currentVelocity.getDy(), 2);
        //returning new velocity with the same speed
        double newVelocity = (Math.sqrt(xSpeed + ySpeed));
        if (collisionX >= startingPointX && collisionX <= startingPointX + fifth) {
            return Velocity.fromAngleAndSpeed(300, newVelocity);
        } else if (collisionX >= startingPointX + fifth && collisionX <= startingPointX + fifth * 2) {
            return Velocity.fromAngleAndSpeed(330, newVelocity);
        } else if (collisionX >= startingPointX + fifth * 2 && collisionX <= startingPointX + fifth * 3) {
            return Velocity.fromAngleAndSpeed(0, newVelocity);
        } else if (collisionX >= startingPointX + fifth * 3 && collisionX <= startingPointX + fifth * 4) {
            return Velocity.fromAngleAndSpeed(30, newVelocity);
        } else {
            return Velocity.fromAngleAndSpeed(60, newVelocity);
        }
    }

    /**
     * Add this paddle to the game.
     *
     * @param g adding to the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}