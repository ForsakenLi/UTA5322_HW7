package expert;

import java.awt.*;

public interface Expert {
    void draw(int offsetX, int offsetY, Graphics graphics);
    void undoDraw(int offsetX, int offsetY, Graphics graphics);
}
