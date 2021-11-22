package state;

import facade.BananaFacade;
import facade.MonkeyFacade;
import game.GameController;
import game.GameGUI;
import util.DirectionKeyListener;
import util.Timer;

public class GameOverState extends State {

    private static final GameOverState instance = new GameOverState();

    private GameOverState(){}

    public static GameOverState getInstance() {
        return instance;
    }

    @Override
    public State startBtnClicked() {
        DirectionKeyListener.getInstance().enableListener();
        setGameTimer();
        MonkeyFacade.getInstance().Init();
        BananaFacade.getInstance().Init();
        GameController.getInstance().InitScore();
        setBananaTimer();
        return MovingState.getInstance();
    }


    public void setGameTimer() {
        String item = (String) GameGUI.getInstance().getTimeSelector().getSelectedItem();
        if (item != null) {
            Timer timer = new Timer(10);
            switch (item) {
                case "30sec":
                    timer = new Timer(30);
                    break;
                case "1min":
                    timer = new Timer(60);
                    break;
                case "2min":
                    timer = new Timer(120);
                    break;
                case "3min":
                    timer = new Timer(180);
                    break;
            }
            timer.setIsGameTime(true);
            GameController.ThreadNumber++;
            timer.setThreadNum(GameController.ThreadNumber);
            new Thread(timer).start();
        }
    }
}
