/**
 * @author Gil Getalew Tshale 321062382 <tashala159@gmail.com>.
 * version 13.0.2" 2020-01-14
 * @since 18.04.2020
 */

/**
 * class to update  counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor of ScoreTrackingListener.
     *
     * @param scoreCounter updating the current score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * increasing the score by 5 points when block is getting hit by a ball.
     *
     * @param beingHit block notifying for being hit.
     * @param hitter   ball notifying for hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}