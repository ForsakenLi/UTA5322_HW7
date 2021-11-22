package facade;

import expert.BoxExpert;
import expert.Expert;
import javafx.util.Pair;
import util.OffsetUtil;

import java.awt.*;

public class MonkeyFacade {
    private final Expert drawExpert;
    private int x, y;
    private final Graphics graphics;
    private static final Color MONKEY_COLOR = Color.ORANGE.darker();
    private static MonkeyFacade instance;

    public static MonkeyFacade getInstance() {
        return instance;
    }

    public static void setInstance(MonkeyFacade facade) {
        instance = facade;
    }

    public MonkeyFacade(Graphics graphics) {
        drawExpert = new BoxExpert(MONKEY_COLOR);
        x = 5;
        y = 5;
        this.graphics = graphics;
    }

    public void Init() {
        x = 5;
        y = 5;
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.draw(location.getKey(), location.getValue(), graphics);

    }

    public void MoveUp() {
        if (y - 1 < 0){
            return;
        }
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.undoDraw(location.getKey(), location.getValue(), graphics);
        y--;
        location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.draw(location.getKey(), location.getValue(), graphics);
    }

    public void MoveDown() {
        if (y + 1 > 10){
            return;
        }
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.undoDraw(location.getKey(), location.getValue(), graphics);
        y++;
        location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.draw(location.getKey(), location.getValue(), graphics);
    }

    public void MoveLeft() {
        if (x - 1 < 0){
            return;
        }
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.undoDraw(location.getKey(), location.getValue(), graphics);
        x--;
        location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.draw(location.getKey(), location.getValue(), graphics);
    }

    public void MoveRight() {
        if (x + 1 > 10){
            return;
        }
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.undoDraw(location.getKey(), location.getValue(), graphics);
        x++;
        location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.draw(location.getKey(), location.getValue(), graphics);
    }

    public void Clean() {
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.undoDraw(location.getKey(), location.getValue(), graphics);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
