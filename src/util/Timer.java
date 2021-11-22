package util;

import game.GameController;
import state.State;

public class Timer implements Runnable {
    private final int second;
    private boolean isGameTime = false;
    private int threadNum;

    public Timer(int second) {
        this.second = second;
    }

    public void setIsGameTime(boolean gameTime) {
        isGameTime = gameTime;
    }

    public void setThreadNum(int num) {
        threadNum = num;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (GameController.getInstance().GameIsOver()){
            return;
        }
        if (isGameTime) {
            if (threadNum != GameController.ThreadNumber) {
                return;
            }
            GameController.getInstance().gameTimeOver();
        } else {
            if (threadNum != State.getThreadNumber()) {
                return;
            }
            GameController.getInstance().bananaTimeOver();
        }

    }
}
