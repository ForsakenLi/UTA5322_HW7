package state;

public class OvertimeState extends State {

    private static final OvertimeState instance = new OvertimeState();

    private OvertimeState(){}

    public static OvertimeState getInstance() {
        return instance;
    }

    @Override
    public State newBananaPlaced() {
        setBananaTimer();
        return MovingState.getInstance();
    }
}
