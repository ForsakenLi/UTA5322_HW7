package state;

import facade.BananaFacade;
import facade.MonkeyFacade;
import util.DirectionKeyListener;
import util.Timer;

public abstract class State {
    // when the timerThread's number equal to this, the thread will call the Controller, otherwise it
    // will do nothing
    protected static int threadNumber = 1;
    public static int getThreadNumber() {
        return threadNumber;
    }

    protected Thread timerThread;
    public State startBtnClicked() {
        return this;
    }

    public State endBtnClicked() {
        BananaFacade.getInstance().Clean();
        MonkeyFacade.getInstance().Clean();
        DirectionKeyListener.getInstance().disableListener();
        return GameOverState.getInstance();
    }

    public State gameOvertime() {
        BananaFacade.getInstance().Clean();
        MonkeyFacade.getInstance().Clean();
        DirectionKeyListener.getInstance().disableListener();
        return GameOverState.getInstance();
    }

    public State bananaOvertime() {
        return this;
    }

    public State newBananaPlaced() {
        return this;
    }

    public State monkeyFindBanana() {
        return this;
    }

    protected void setBananaTimer() {
        threadNumber++;
        Timer timer = new Timer(5);
        timer.setThreadNum(threadNumber);
        timerThread = new Thread(timer);
        timerThread.start();
    }
}
