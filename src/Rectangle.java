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
 * class of Rectangle, this is an object that helps us to draw ractangles, paddle .
 * in order to define it we will use in line borders .
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;


    /**
     * constructor of rectangle.
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft given starting point of left upper corner for a rectangle.
     * @param width     given width of the rectangle.
     * @param height    given height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * constructor of rectangle.
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft given starting point of left upper corner for a rectangle.
     * @param width     given width of the rectangle.
     * @param height    given height of the rectangle.
     * @param color     given color of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * setter of upperLeft point.
     *
     * @param upperleftCorner given starting point of left upper corner for a rectangle.
     */
    public void setUpperLeft(Point upperleftCorner) {
        this.upperLeft = upperleftCorner;
    }

    /**
     * setter of upperLeft point.
     *
     * @param rectangleWidth given rectangleWidth  of the rectangle.
     */
    public void setWidth(double rectangleWidth) {
        this.width = rectangleWidth;
    }

    /**
     * setter of upperLeft point.
     *
     * @param rectangleHeight given rectangleWidth  of the rectangle.
     */
    public void setHeight(double rectangleHeight) {
        this.height = rectangleHeight;
    }

    /**
     * getter of color.
     *
     * @return Color
     */
    public Color getColor() {
        return color;
    }

    /**
     * setter of color.
     *
     * @param color1 given color
     */
    public void setColor(Color color1) {
        this.color = color1;
    }

    /**
     * setter of upperLeft.
     *
     * @return point , gets the upperLeft point.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * getter of width.
     *
     * @return width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * getter of height.
     *
     * @return height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * drawing the recangle .
     *
     * @param surface drawing .
     */
    public void drawRectangle(DrawSurface surface) {
        if (color != null) {
            surface.setColor(color);
        }
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }

    /**
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line given line .
     * @return List op intersection points.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<>();
        // creating the rectangle from 4 lines: upperLine,leftRectLine,rightRectLine,downRectLine

        //adding intersection points between given line to the list, and rectangle and returning the list.
        if (line.isIntersecting(createLines().get(0))) {
            points.add(line.intersectionWith(createLines().get(0)));
        }
        if (line.isIntersecting(createLines().get(1))) {
            points.add(line.intersectionWith(createLines().get(1)));
        }
        if (line.isIntersecting(createLines().get(2))) {
            points.add(line.intersectionWith(createLines().get(2)));
        }
        if (line.isIntersecting(createLines().get(3))) {
            points.add(line.intersectionWith(createLines().get(3)));
        }
        return points;
    }

    /**
     * createLines of game border.
     *
     * @return List<Line> .
     */
    public List<Line> createLines() {
        List<Line> lines = new ArrayList<>();
        Line upperLine = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
        Line leftRectLine = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(),
                upperLeft.getY() + height);
        Line rightRectLine = new Line(upperLeft.getX() + width, upperLeft.getY(), upperLeft.getX() + width,
                upperLeft.getY() + height);
        Line downRectLine = new Line(upperLeft.getX(), upperLeft.getY() + height, upperLeft.getX() + width,
                upperLeft.getY() + height);
        lines.add(upperLine);
        lines.add(leftRectLine);
        lines.add(rightRectLine);
        lines.add(downRectLine);
        return lines;
    }

    /**
     * method that helps to know where exactly is the hit point of the ball on the rectangle.
     *
     * @param collisionPoint given point
     * @return where is the hit on the rectangle
     */
    public String whereIsTheHit(Point collisionPoint) {
        if (createLines().get(0).onTheLine(collisionPoint)) {
            return "UP";
        } else if (createLines().get(1).onTheLine(collisionPoint)) {
            return "LEFT";
        } else if (createLines().get(2).onTheLine(collisionPoint)) {
            return "RIGHT";
        } else if (createLines().get(3).onTheLine(collisionPoint)) {
            return "DOWN";
        } else {
            return "NONE";
        }
    }

    /**
     * method that tells me about any given.
     * point if it is inside the rectangle.
     *
     * @param p given point
     * @return 1 or 0 ,1 =yes 0=no.
     */
    public boolean pointInside(Point p) {
        double myX = p.getX();
        double myY = p.getY();
        return myX > upperLeft.getX() && myX < upperLeft.getX() + width
                && myY > upperLeft.getY() && myY < upperLeft.getY() + height;
    }
}