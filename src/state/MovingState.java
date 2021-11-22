package state;

import game.GameController;

public class MovingState extends State {

    private static final MovingState instance = new MovingState();

    private MovingState(){}

    public static MovingState getInstance() {
        return instance;
    }

    @Override
    public State bananaOvertime() {
        return OvertimeState.getInstance();
    }

    @Override
    public State monkeyFindBanana() {
        GameController.getInstance().PlusScore();
        return EatBananaState.getInstance();
    }
}
