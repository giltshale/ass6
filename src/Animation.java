import biuoop.DrawSurface;

/**
 * we will take the template-methods and put them in an interface.
 */
public interface Animation {
    /**
     * doing one frame.
     *
     * @param d draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return if it should stop.
     */
    boolean shouldStop();
}