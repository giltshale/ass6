/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

/**
 * ball removing class that implements HitListener.
 * so the class knows to listen when it gets a hit.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * removing balls  from the game and updating game.
     *
     * @param gameLevel1      receive game and  updating new game.
     * @param remainingBalls1 receive balls and  updating how many balls have left.
     */
    public BallRemover(GameLevel gameLevel1, Counter remainingBalls1) {
        this.gameLevel = gameLevel1;
        this.remainingBalls = remainingBalls1;
    }

    /**
     * overides htEvent method so is can do update and decrease ball amount.
     *
     * @param beingHit block notifying that it get hit .
     * @param hitter   ball notifying that it hit .
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(1);
    }
}
