package game;

import facade.BananaFacade;
import facade.MonkeyFacade;
import state.GameOverState;
import state.State;
import util.DirectionKeyListener;

public class GameController {
    private State state;
    private final MonkeyFacade monkeyFacade;
    private final BananaFacade bananaFacade;
    private final GameGUI gui;
    private int score;

    private static final GameController instance = new GameController();

    public static GameController getInstance() {
        return instance;
    }

    private GameController() {
        gui = GameGUI.getInstance();
        gui.setVisible(true);
        // if not set visible, the gui.getCanvas().getGraphics() will return null

        // init facade
        monkeyFacade = new MonkeyFacade(gui.getCanvas().getGraphics());
        MonkeyFacade.setInstance(monkeyFacade);
        bananaFacade = new BananaFacade(gui.getCanvas().getGraphics());
        BananaFacade.setInstance(bananaFacade);

        DirectionKeyListener listener = DirectionKeyListener.getInstance();
        gui.getStartButton().addKeyListener(listener);

        // Controller is the client of the State class
        state = GameOverState.getInstance();
        
        gui.getStartButton().addActionListener(e -> {
            state = state.startBtnClicked();
        });

        gui.getEndButton().addActionListener(e -> {
            state = state.endBtnClicked();
        });

    }

    public void gameTimeOver() {
        System.out.println("time run off");
        state = state.gameOvertime();
    }

    public void bananaTimeOver() {
        state = state.bananaOvertime();
        BananaFacade.getInstance().ReplacedBanana();
        state = state.newBananaPlaced();
    }

    public void monkeyMoveNotify() {
        if (monkeyFacade.getX() == bananaFacade.getX() && monkeyFacade.getY() == bananaFacade.getY()) {
            state = state.monkeyFindBanana();
            BananaFacade.getInstance().ReplacedBanana();
            state = state.newBananaPlaced();
        }
    }

    public void InitScore() {
        score = 0;
        String format = String.format("Score: %d", score);
        gui.getScoreBoard().setText(format);
    }

    public void PlusScore() {
        score++;
        String format = String.format("Score: %d", score);
        gui.getScoreBoard().setText(format);
    }

    public boolean GameIsOver() {
        return state instanceof GameOverState;
    }

    public static int ThreadNumber = 1000;
}
