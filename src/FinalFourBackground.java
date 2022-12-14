import biuoop.DrawSurface;

import java.awt.Color;

/**
 * DirectHitBackground is a class the.
 * extends background so i can add drawings on the background.
 */
public class FinalFourBackground extends BackGround {
    /**
     * constructor DirectHitBackground.
     *
     * @param rectangle rectangle.
     */
    public FinalFourBackground(Rectangle rectangle) {
        super(rectangle);
    }

    /**
     * drawing the circles and lines on the background.
     *
     * @param d drawing.
     */
    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(Color.WHITE);
        //left lines
        d.drawLine(140, 450, 120, 610);
        d.drawLine(150, 450, 130, 610);
        d.drawLine(160, 450, 140, 610);
        d.drawLine(170, 450, 150, 610);
        d.drawLine(180, 450, 160, 610);
        d.drawLine(190, 450, 170, 610);
        d.drawLine(200, 450, 180, 610);
        d.drawLine(210, 450, 190, 610);
        d.drawLine(220, 450, 200, 610);
        d.drawLine(230, 450, 210, 610);
         //right lines
        d.drawLine(140 + 400, 500 + 50, 120 + 400, 610);
        d.drawLine(150 + 400, 500 + 50, 130 + 400, 610);
        d.drawLine(160 + 400, 500 + 50, 140 + 400, 610);
        d.drawLine(170 + 400, 500 + 50, 150 + 400, 610);
        d.drawLine(180 + 400, 500 + 50, 160 + 400, 610);
        d.drawLine(190 + 400, 500 + 50, 170 + 400, 610);
        d.drawLine(200 + 400, 500 + 50, 180 + 400, 610);
        d.drawLine(210 + 400, 500 + 50, 190 + 400, 610);
        d.drawLine(220 + 400, 500 + 50, 200 + 400, 610);
        d.drawLine(230 + 400, 500 + 50, 210 + 400, 610);
        //left side
        d.setColor(new Color(196, 193, 193));
        d.fillCircle(180 - 35, 450 - 20, 15);
        d.setColor(new Color(194, 188, 188));
        d.fillCircle(180 - 40, 450, 20);
        d.setColor(new Color(201, 197, 197));
        d.fillCircle(180, 450 - 20, 26);
        d.setColor(new Color(186, 174, 174));
        d.fillCircle(180 - 14, 450 + 10, 20);
        d.setColor(new Color(208, 202, 202));
        d.fillCircle(180 + 28, 450, 30);
        d.setColor(Color.GRAY);
         //right side
        d.setColor(new Color(196, 193, 193));
        d.fillCircle(550, 500 + 35, 20);
        d.setColor(new Color(194, 188, 188));
        d.fillCircle(562, 500 + 10, 15);
        d.setColor(new Color(201, 197, 197));
        d.fillCircle(575, 500 + 30, 26);
        d.setColor(new Color(201, 195, 195));
        d.fillCircle(580, 500 + 50, 20);
        d.setColor(new Color(186, 185, 185));
        d.fillCircle(610, 500 + 25, 33);

    }
}
