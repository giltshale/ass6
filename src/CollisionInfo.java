/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

/**
 * class tha can detacte where is the collision point and with what collidable it hits .
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidable;

    /**
     * returns the  point at which the collision occurs.
     *
     * @param collisionPoint the point at which the collision occurs.
     * @param collidable     the collidable object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collidable) {
        this.collisionPoint = collisionPoint;
        this.collidable = collidable;
    }

    /**
     * the point at which the collision occurs.
     *
     * @return the collision point
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * the collidable object involved in the collision.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return collidable;
    }
}