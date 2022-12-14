/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

import java.util.ArrayList;
import java.util.List;


/**
 * During the game, there are going to be many objects a Ball can collide with.
 * The GameEnvironment class will be a collection of such things.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor of GameEnvironment.
     */
    public GameEnvironment() {
        collidables = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c given collidable.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory receive the ball movement
     * @return CollisionInfo of the ball
     */

    public CollisionInfo getClosestCollision(Line trajectory) {
        //if the collidables list is empty
        if (collidables.size() == 0) {
            return null;
        }
        //initializing the first collidable in the list to be the minimum.
        Collidable minCollidable = collidables.get(0);
        //updating the minimum collision in order to find the minimum Collidable
        for (Collidable c : collidables) {
            if (trajectory.getStart().distance(trajectory.
                    closestIntersectionToStartOfLine(c.getCollisionRectangle()))
                    < trajectory.getStart().distance(trajectory.
                    closestIntersectionToStartOfLine(minCollidable.getCollisionRectangle()))) {
                minCollidable = c;
            }
        }
        // updating the minimum point to be the one i found in "for " loop
        Point minPoint = trajectory.closestIntersectionToStartOfLine(minCollidable.getCollisionRectangle());
        //returning the new collisionInfo with the minPoint and minCollidable.
        return new CollisionInfo(minPoint, minCollidable);
    }

    /**
     * check if ball is inside the rectangle.
     *
     * @param p the srting point .
     * @return rectangle that its inside.
     */
    public Rectangle getsInside(Point p) {
        boolean getsInside = false;
        Rectangle insideMe = null;
        for (Collidable c : collidables) {
            if (c.getCollisionRectangle().pointInside(p)) {
                getsInside = true;
                insideMe = c.getCollisionRectangle();
            }
        }
        return insideMe;
    }

    /**
     * removing collidable blocks from the game.
     *
     * @param c receive collidable
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }
}
