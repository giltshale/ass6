/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * A point has an x and a y value, and can measure the distance to.
 * other points, and if it is equal to another point.
 */
public class Point {
    private double x;
    private double y;

    /**
     * point constructor.
     *
     * @param x x value.
     * @param y y value.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * x value getter.
     *
     * @return double x.
     */
    public double getX() {
        return x;
    }

    /**
     * x value setter .
     *
     * @param sx .
     */
    public void setX(double sx) {
        this.x = sx;
    }

    /**
     * y value getter.
     *
     * @return double y.
     */
    public double getY() {
        return y;
    }

    /**
     * y value setter .
     *
     * @param ys .
     */
    public void setY(double ys) {
        this.y = ys;
    }

    /**
     * distance -- return the distance of this point to the other point using sqrt equation.
     *
     * @param other point
     * @return double
     */
    public double distance(Point other) {
        if (other == null) {
            return Double.POSITIVE_INFINITY;
        }
        double xDiffPow = Math.pow(x - other.getX(), 2);
        double yDiffPow = Math.pow(y - other.getY(), 2);
        return Math.sqrt(xDiffPow + yDiffPow);
    }

    /**
     * equals -- return true is the points are equal, false otherwise.
     *
     * @param other point
     * @return boolean 1 or 0 .
     */
    public boolean equals(Point other) {
        return x == other.getX() && y == other.getY();
    }

    /**
     * create a random-number generator between x,1-400 and y,1-300.
     * Create a window with which is 400 pixels wide and 300 pixels high.
     *
     * @param width  width.
     * @param height height.
     * @return Point
     */
    public static Point generateRandomPoint(int width, int height) {
        Random rand = new Random(); // create a random-number generator
        int x = rand.nextInt(width) + 1; // get integer in range 1-400
        int y = rand.nextInt(height) + 1; // get integer in range 1-300
        return new Point(x, y);
    }

    /**
     * receive drawing graphics to a window,point,radius color, and drawing circle with that .
     *
     * @param p      point.
     * @param d      drawing graphics to a window
     * @param radius radius.
     * @param color  color.
     */
    public static void drawCircle(Point p, DrawSurface d, int radius, Color color) {
        d.setColor(color);
        d.fillCircle((int) p.getX(), (int) p.getY(), radius);
    }
}
