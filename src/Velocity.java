/**
 * Gil Getalew Tshale 321062382 <tashala159@gmail.com>
 * version 13.0.2" 2020-01-14
 *
 * @since 18.04.2020
 */

import java.util.Random;

/**
 * specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * get x .
     *
     * @return double
     */
    public double getDx() {
        return dx;
    }

    /**
     * get y.
     *
     * @return double
     */
    public double getDy() {
        return dy;
    }

    /**
     * constructor of x , y value.
     *
     * @param dx .
     * @param dy .
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * calculates velocity from the value of Angle And speed.
     *
     * @param angle .
     * @param speed .
     * @return Velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = 1 * speed * Math.sin(Math.toRadians(angle));
        double dy = -1 * speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * Take a point with position (x,y) and return a new point.
     * with position (x+dx, y+dy)
     *
     * @param p point
     * @return new point, after change (move).
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }

    /**
     * creating Random Velocity for each ball according to his size.
     *
     * @param size ball size.
     * @return Velocity
     */
    public static Velocity createRandomVelocity(int size) {
        Random rand = new Random(); // create a random-number generator
        int degrees = rand.nextInt(361); // get integer in range 0-360
        if (size > 50) {
            return fromAngleAndSpeed(degrees, 1);
        }
        return fromAngleAndSpeed(degrees, 50.00 / size);
    }

    /**
     * setter of speed.
     *
     * @param dvx x speed.
     */
    public void setDx(double dvx) {
        this.dx = dvx;
    }

    /**
     * setter of speed.
     *
     * @param dvy y speed.
     */
    public void setDy(double dvy) {
        this.dy = dvy;
    }

}