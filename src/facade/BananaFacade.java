package facade;

import expert.CircleExpert;
import expert.Expert;
import javafx.util.Pair;
import util.OffsetUtil;

import java.awt.*;
import java.util.Random;

public class BananaFacade {
    private static final Color BANANA_COLOR = Color.YELLOW.darker();
    private static BananaFacade instance;

    private final Expert drawExpert;
    private int x, y;
    private final Graphics graphics;

    public static BananaFacade getInstance() {
        return instance;
    }

    public static void setInstance(BananaFacade facade) {
        instance = facade;
    }

    public BananaFacade(Graphics graphics) {
        this.graphics = graphics;
        drawExpert = new CircleExpert(BANANA_COLOR);
    }

    public void Init() {
        Shuffle();
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.draw(location.getKey(), location.getValue(), graphics);
    }

    public void ReplacedBanana() {
        Pair<Integer, Integer> location = OffsetUtil.getDisplayLocation(x, y);
        drawExpert.undoDraw(location.getKey(), location.getValue(), graphics);
        Shuffle();
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

    private void Shuffle() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        x = random.nextInt(10);
        y = random.nextInt(10);
    }

}
