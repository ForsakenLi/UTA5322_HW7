package state;

public class EatBananaState extends State {

    private static final EatBananaState instance = new EatBananaState();

    private EatBananaState(){}

    public static EatBananaState getInstance() {
        return instance;
    }

    @Override
    public State newBananaPlaced() {
        setBananaTimer();
        return MovingState.getInstance();
    }
}
