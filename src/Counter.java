/**
 * counting class that helps to increase/decrease certain amount of number
 * and know the asked value at each point of the game.
 */
public class Counter {
    private int count;

    /**
     * constructor.
     * initializing counter to zero.
     */
    public Counter() {
        count = 0;
    }

    /**
     * constructor.
     *
     * @param count1 receives number of count.
     */
    public Counter(int count1) {
        count = count1;
    }

    /**
     * add number to current count.
     *
     * @param number added number.
     */
    void increase(int number) {
        count += number;
    }

    /**
     * subtract number from current count.
     *
     * @param number subtracted number.
     */
    void decrease(int number) {
        count -= number;
    }

    /**
     * get current count.
     *
     * @return the current count.
     */
    int getValue() {
        return count;
    }
}