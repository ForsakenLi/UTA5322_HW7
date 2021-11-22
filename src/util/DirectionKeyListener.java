package util;

import facade.MonkeyFacade;
import game.GameController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// This class should be a part of the GameController, to prettify the controller code, I make this a independent class
public class DirectionKeyListener implements KeyListener {

    private final MonkeyFacade monkeyFacade;
    private boolean enabled;

    private static final DirectionKeyListener instance = new DirectionKeyListener();

    public static DirectionKeyListener getInstance() {
        return instance;
    }
    
    private DirectionKeyListener() {
        monkeyFacade = MonkeyFacade.getInstance();
        enabled = false;
    }

    public void keyTyped(KeyEvent e) {
        // can't work on macOS
    }
    
    public void keyPressed(KeyEvent e) {
        if (!enabled) {
            return;
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                monkeyFacade.MoveUp();
                break;
            case KeyEvent.VK_DOWN:
                monkeyFacade.MoveDown();
                break;
            case KeyEvent.VK_LEFT:
                monkeyFacade.MoveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                monkeyFacade.MoveRight();
                break;
            default:
                return;
        }
        GameController.getInstance().monkeyMoveNotify();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void enableListener() {
        enabled = true;
    }
    
    public void disableListener() {
        enabled = false;
    }
}
