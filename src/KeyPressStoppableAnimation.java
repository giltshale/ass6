import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * decorator-class that will wrap an existing animation and add.
 * a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor of KeyPressStoppableAnimation.
     *
     * @param sensor1    sensor that will be pressed.
     * @param key1       key that will be pressed.
     * @param animation1 the animation that we use.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor1, String key1, Animation animation1) {
        sensor = sensor1;
        key = key1;
        animation = animation1;
        stop = false;
        isAlreadyPressed = true;
    }

    /**
     * letting know in witch conditions we will stop using the key pressing.
     *
     * @param d draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!sensor.isPressed(key)) {
            isAlreadyPressed = false;
        }
        animation.doOneFrame(d);
        if (sensor.isPressed(key) && !isAlreadyPressed) {
            stop = true;
        }
    }

    /**
     * always stop.
     *
     * @return stop.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}