/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;

import java.awt.Color;


/**
 * Class of a Ball (actually, a circle). Balls have size (radius), color, and location (a Point).
 * Balls also know how to draw themselves on a DrawSurface.
 */
public class Ball implements Sprite {
    /* keeping the ball ,center ,radius ,color and speed for.
    future use,and deceiding about the start of my frame*/
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private int topFrame = 0;
    private int leftFrame = 0;
    private GameEnvironment gameEnvironment;

    /**
     * ball constructor.
     *
     * @param centerMiddle x, y of ball center.
     * @param c            color.
     * @param radius       radius.
     */
    public Ball(Point centerMiddle, int radius, java.awt.Color c) {
        this.center = centerMiddle;
        this.radius = radius;
        this.color = c;
    }

    /**
     * ball constructor.
     *
     * @param center          receive center.
     * @param radius          receive radius.
     * @param color           receive color.
     * @param velocity        receive velocity.
     * @param gameEnvironment receive gameEnvironment.
     */
    public Ball(Point center, int radius, Color color, Velocity velocity, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.velocity = velocity;
        //  this.topFrame = topFrame;
        //    this.leftFrame = leftFrame;
        this.gameEnvironment = gameEnvironment;
    }
    /* ball constructor for future use. */
   /* public Ball(Point center, int radius, Color color, Velocity velocity) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.velocity = velocity;
    }*/

    /**
     * ball constructor for flexibity use with coordinates x, y .
     *
     * @param x     x value
     * @param y     x value
     * @param r     radius  value
     * @param color color
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        center = new Point(x, y);
        radius = r;
        this.color = color;
    }

    /**
     * accessors, getter of x.
     *
     * @return int
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * accessors, getter of y.
     *
     * @return int
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * accessors, getter of size of the ball.
     *
     * @return int.
     */
    public int getSize() {
        return radius * 2;
    }

    /**
     * accessors, getter of Color of the ball.
     *
     * @return Color
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * getCenter.
     *
     * @return Point
     */
    public Point getCenter() {
        return center;
    }

    /**
     * setter of Center.
     *
     * @param centerMiddle x ,y of the point center
     */
    public void setCenter(Point centerMiddle) {
        this.center = centerMiddle;
    }

    /**
     * getter of radius.
     *
     * @return int
     */
    public int getRadius() {
        return radius;
    }

    /**
     * setter of radius.
     *
     * @param r x, y of ball
     */
    public void setRadius(int r) {
        this.radius = r;
    }

    /**
     * getter of color.
     *
     * @param c ball color.
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface Surface Drawing.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle(getX(), getY(), radius);
        surface.setColor(Color.BLACK);
        surface.drawCircle(getX(), getY(), radius);
    }

    /**
     * starting the move one step method when time passes.
     */
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * setter of velocity.
     *
     * @param v velocity.
     */
    public void setVelocity(Velocity v) {
        velocity = v;
    }

    /**
     * setter of velocity.
     *
     * @param dx velocity.
     * @param dy velocity.
     */
    public void setVelocity(double dx, double dy) {
        velocity = new Velocity(dx, dy);
    }

    /**
     * getter of velocity.
     *
     * @return Velocity
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * getter of topFrame.
     *
     * @return topFrame
     */
    public int getTopFrame() {
        return topFrame;
    }

    /**
     * setter.
     *
     * @param topFrame1 sets TopFrame.
     */
    public void setTopFrame(int topFrame1) {
        this.topFrame = topFrame1;
    }

    /**
     * getter.
     *
     * @return gets LeftFrame.
     */
    public int getLeftFrame() {
        return leftFrame;
    }

    /**
     * setter.
     *
     * @param leftFrame1 sets leftFrame.
     */
    public void setLeftFrame(int leftFrame1) {
        this.leftFrame = leftFrame1;
    }

    /**
     * @return gets GameEnvironment.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * setter of gameEnvironment.
     *
     * @param gameEnvironment1 users input.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * create an animation with a moving ball speed and direction.according to where the ball hits.
     */
    public void moveOneStep() {

        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.getCenter()));
        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
        Point previousPoint = this.center;
        if (collisionInfo.collisionPoint() != null) {
            //  if ball hits somewhere ,change the direction of ball speed according where it hits.
            this.setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.velocity));

            Point collisionPoint = collisionInfo.collisionPoint();
            // for knowing where ball hits the  block
            String whereHit = collisionInfo.collisionObject().getCollisionRectangle().
                    whereIsTheHit(collisionInfo.collisionPoint());
            //size of epsilon like size of ball radius for good looking movement.
            double epsilon = 3;
            switch (whereHit) {
                case "UP":
                    this.center = new Point(collisionPoint.getX(), collisionPoint.getY() + epsilon);
                    break;
                case "DOWN":
                    this.center = new Point(collisionPoint.getX(), collisionPoint.getY() - epsilon);
                    break;
                case "LEFT":
                    this.center = new Point(collisionPoint.getX() - epsilon, collisionPoint.getY());
                    break;
                case "RIGHT":
                    this.center = new Point(collisionPoint.getX() + epsilon, collisionPoint.getY());
                    break;
                default:
                    this.center = this.getVelocity().applyToPoint(collisionPoint);
                    break;
            }
        } else {
            this.center = this.getVelocity().applyToPoint(this.getCenter());
        }
        if (gameEnvironment.getsInside(this.getCenter()) != null) {
            this.center = previousPoint;
        }
    }

    /**
     * Domain definition for starting coordinates.
     *
     * @param top  y start (0)
     * @param left x start (0)
     */
    public void frameStart(int top, int left) {
        this.topFrame = top;
        this.leftFrame = left;
    }

    /**
     * create an animation with a moving ball speed and direction.
     *
     * @param width  frame width .
     * @param height frame height.
     */
    public void moveOneStep(int width, int height) {

        this.center = this.getVelocity().applyToPoint(this.getCenter());
        //ball moves right
        if ((getVelocity().getDx() > 0) && (this.getX() + this.getRadius() + this.getVelocity().getDx() > width)) {
            this.setVelocity(-1 * this.getVelocity().getDx(), this.getVelocity().getDy());
        }
        //ball moves left
        if ((getVelocity().getDx() < 0) && (this.getX() + this.getVelocity().getDx() < this.getRadius() + leftFrame)) {
            this.setVelocity(-1 * this.getVelocity().getDx(), this.getVelocity().getDy());
        }
        //ball moves down
        if ((getVelocity().getDy() > 0) && (this.getY() + this.getRadius() + this.getVelocity().getDy() > height)) {
            this.setVelocity(this.getVelocity().getDx(), -1 * this.getVelocity().getDy());
        }
        //ball moves up
        if ((getVelocity().getDy() < 0) && (this.getY() + this.getVelocity().getDy() < this.getRadius() + topFrame)) {
            this.setVelocity(this.getVelocity().getDx(), -1 * this.getVelocity().getDy());
        }
        // moveOneStep();
    }

    /**
     * sprites  remove from the game.
     *
     * @param g receives the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

}