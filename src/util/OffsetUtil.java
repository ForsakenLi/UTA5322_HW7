package util;

import javafx.util.Pair;

public class OffsetUtil {
    public static int WIDTH_LEN = 800;
    public static int HEIGHT_LEN = 800;
    public static int INIT_X = 400;
    public static int INIT_Y = 400;
    private static final int offset = 70;

    public static Pair<Integer, Integer> getDisplayLocation(int x, int y) {
        int offsetX, offsetY;
        if (x == 5) {
            offsetX = INIT_X;
        } else if (x > 5) {
            offsetX = INIT_X + offset * (x - 5);
        } else {
            offsetX = INIT_X - offset * (5 - x);
        }
        if (y == 5) {
            offsetY = INIT_Y;
        } else if (y > 5) {
            offsetY = INIT_Y + offset * (y - 5);
        } else {
            offsetY = INIT_Y - offset * (5 - y);
        }

        return new Pair<>(offsetX, offsetY);
    }


}
