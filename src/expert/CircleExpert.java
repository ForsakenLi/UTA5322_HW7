package expert;

import java.awt.*;

public class CircleExpert implements Expert {
    private final Color color;
    private final static int DIAMETER = 26;

    public CircleExpert(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int offsetX, int offsetY, Graphics graphics) {
        graphics.setPaintMode();
        graphics.setColor(color);
        graphics.drawOval(offsetX - DIAMETER/2, offsetY - DIAMETER/2, DIAMETER, DIAMETER);
    }

    @Override
    public void undoDraw(int offsetX, int offsetY, Graphics graphics) {
        graphics.setPaintMode();
        graphics.setColor(Color.WHITE);
        graphics.drawOval(offsetX - DIAMETER/2, offsetY - DIAMETER/2, DIAMETER, DIAMETER);
    }
}
