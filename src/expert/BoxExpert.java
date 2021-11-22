package expert;

import java.awt.*;

public class BoxExpert implements Expert {
    private final Color color;
    private final static int EDGE_LEN = 30;

    public BoxExpert(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int offsetX, int offsetY, Graphics graphics) {
        graphics.setPaintMode();
        graphics.setColor(color);
        graphics.drawRect(offsetX - EDGE_LEN/2, offsetY - EDGE_LEN/2, EDGE_LEN, EDGE_LEN);
    }

    @Override
    public void undoDraw(int offsetX, int offsetY, Graphics graphics) {
        graphics.setPaintMode();
        graphics.setColor(Color.WHITE);
        graphics.drawRect(offsetX - EDGE_LEN/2, offsetY - EDGE_LEN/2, EDGE_LEN, EDGE_LEN);
    }


}
