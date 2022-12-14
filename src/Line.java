/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;


/**
 * A line (actually a line-segment) connects two points -- a start point and an end point.
 * Lines have lengths,and may intersect with other lines.
 * It can also tell if it is the same as another line segment.
 */
public class Line {
    // starting point (x1,y1) and ending  point (x2,y2) of a line.
    private Point start;
    private Point end;
    // for accuracy
    static final double EPSILON = 0.00000000001;

    /**
     * constructors.
     *
     * @param s point.
     * @param e point.
     */
    public Line(Point s, Point e) {
        this.start = s;
        this.end = e;
    }

    /**
     * representing line with coordinates.
     *
     * @param x1 x of start.
     * @param y1 y of start.
     * @param x2 x of end.
     * @param y2 y  of end.
     */
    public Line(double x1, double y1, double x2, double y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }

    /**
     * Return the length of the line.
     *
     * @return double
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return Point
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    /**
     * Returns the start point of the line.
     *
     * @return Point
     */
    public Point start() {
        return start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return Point
     */
    public Point end() {
        return end;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other different line to compare with.
     * @return boolean, 1 or 0 .
     */
    public boolean isIntersecting(Line other) {
        return intersectionWith(other) != null;
    }

    /**
     * Returns the intersection point if the lines intersect.
     * and null otherwise.
     *
     * @param other different line to compare with.
     * @return Point
     */
    public Point intersectionWith(Line other) {
        Point pA = start;
        Point pB = end;
        Point pC = other.getStart();
        Point pD = other.getEnd();


        // Line AB represented as ta1x + tb1y = tc1
        double yDiffer = pB.getY() - pA.getY();
        double xDiffer = pA.getX() - pB.getX();
        double equationAB = yDiffer * (pA.getX()) + xDiffer * (pA.getY());

        // double equationAB = yDiffer * (pA.getX()) + xDiffer * (pA.getY());
        //  double equationCD = otheryDiffer * (pC.getX()) + otherxDiffer * (pC.getY());


        // Line CD represented as a2x + b2y = c2
        double otheryDiffer = pD.getY() - pC.getY();
        double otherxDiffer = pC.getX() - pD.getX();
        double equationCD = otheryDiffer * (pC.getX()) + otherxDiffer * (pC.getY());
        double det = yDiffer * otherxDiffer - otheryDiffer * xDiffer;

        if (det == 0) {

            //if one line is  parallel and the other is indefinite
            if ((xDiffer == 0) && (yDiffer / xDiffer) == 0) {
                double x = pA.getX();
                double y = equationCD - (otheryDiffer * (pC.getX())) / otherxDiffer;
                Point np = new Point(x, y);
                this.onTheLine(np);
                return np;
            }

            //if lines continue one an other
            if (this.end.getX() == other.start.getX() && (this.end.getY() == other.start.getY())) {
                return this.end();
            }
            //if other line starts were the first line ends
            if ((this.start.getX() == other.end.getX()) && (this.start.getY() == other.end.getY())) {
                return this.start();
            }
            // //if other line ends were the first line ends
            if ((this.end.getX() == other.end.getX()) && (this.end.getY() == other.end.getY())
                    && (this.start.getX() != other.start.getX()) && (this.start.getY() != other.start.getY())) {
                return this.end();
            }
            //if other line starts were the first line starts
            if ((this.start.getX() == other.start.getX()) && (this.start.getY() == other.start.getY())
                    && (this.end.getX() != other.end.getX()) && (this.end.getY() != other.end.getY())) {
                return this.start();
            }

            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return null;
        } else {
            //finding the cross point
            double x = ((otherxDiffer * equationAB - xDiffer * equationCD) / det);
            double y = (yDiffer * equationCD - equationAB * otheryDiffer) / det;
            Point np = new Point(x, y);
            if (this.onTheLine(np) && other.onTheLine(np)) {
                return np;
            } else {
                return null;
            }
        }

    }

    /**
     * equals -- return true is the lines are equal, false otherwise.
     *
     * @param other other line.
     * @return boolean 1 or 0.
     */
    public boolean equals(Line other) {
        return (start.equals(other.getStart()) && end.equals(other.getEnd()))
                || (start.equals(other.getEnd()) && end.equals(other.getStart()));
    }

    /**
     * getter for start.
     *
     * @return Point
     */
    public Point getStart() {
        return start;
    }

    /**
     * setter for start.
     *
     * @param s starting point.
     */
    public void setStart(Point s) {
        this.start = s;
    }

    /**
     * getter for end point.
     *
     * @return Point
     */
    public Point getEnd() {
        return end;
    }

    /**
     * setter for end point.
     *
     * @param e end point.
     */
    public void setEnd(Point e) {
        this.end = e;
    }

    /**
     * checking if given point is on the line or not.
     *
     * @param p point.
     * @return boolean 1 or 0 .
     */
    public boolean onTheLine(Point p) {
        return Math.abs(start.distance(p) + end.distance(p) - length()) <= EPSILON;
    }

    /**
     * generating Random Line.
     *
     * @param width  frame width
     * @param height frame height
     * @return Line
     */
    public static Line generateRandomLine(int width, int height) {
        return new Line(Point.generateRandomPoint(width, height), Point.generateRandomPoint(width, height));
    }

    /**
     * drawing Lines.
     *
     * @param l line.
     * @param d Drawing Surface
     */
    public static void drawLine(Line l, DrawSurface d) {
        d.setColor(Color.BLACK);
        //getting the starting point and ending point of a line and drawing it
        d.drawLine((int) l.getStart().getX(), (int) l.getStart().getY(), (int) l.getEnd().getX(),
                (int) l.getEnd().getY());
    }

    /**
     * drawing Middle Point of every line.
     *
     * @param l line.
     * @param d DrawSurface.
     */
    public static void drawMiddlePoint(Line l, DrawSurface d) {
        d.setColor(Color.BLUE);
        //getting the middle point of a line and painting it blue
        d.fillCircle((int) l.middle().getX(), (int) l.middle().getY(), 3);
        Point.drawCircle(l.middle(), d, 3, Color.BLUE);
    }


    /**
     * To do -check if its relevant
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     *
     * @param rect rectangle that game is inside
     * @return the point that is closest Intersection To Start Of Line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> points = rect.intersectionPoints(this);
        //if the list is empty
        if (points.size() == 0) {
            return null;
        }
        //initializing the first point in the list to be the minimum
        Point minPoint = points.get(0);
        // changing the minimum if he isn't the minimum.
        for (Point p : points) {
            if (start.distance(p) < start.distance(minPoint)) {
                minPoint = p;
            }
        }
        // returning the minimum
        return minPoint;
    }
}

