package game;

import facade.MonkeyFacade;
import util.OffsetUtil;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 50;

    private static final GameGUI instance = new GameGUI();

    public static GameGUI getInstance() {
        return instance;
    }

    private final JButton startButton;
    private final JButton endButton;
    private final JTextPane scoreBoard;
    private final JTextPane timeHint;
    private final JComboBox<String> timeSelector;
    private final JPanel componentPanel; // container of components
    private final JPanel canvas;
    private final JPanel framePanel;  // container for this Frame

    private GameGUI() {
        // initialize GUI objects
        canvas = new JPanel();
        startButton = new JButton("Start Game");
        endButton = new JButton("End Game");
        timeSelector = new JComboBox<>();
        scoreBoard = new JTextPane();
        scoreBoard.setText("Score: 0");
        scoreBoard.setEditable(false);
        timeHint = new JTextPane();
        timeHint.setText("Box is Monkey and Circle is Banana, choose your game time:");
        timeHint.setEditable(false);
        timeSelector.addItem("30sec");
        timeSelector.addItem("1min");
        timeSelector.addItem("2min");
        timeSelector.addItem("3min");
        componentPanel = new JPanel();
        framePanel = (JPanel) getContentPane();
        initGUI();
    }

    private void initGUI() {
        setSize(OffsetUtil.WIDTH_LEN, OffsetUtil.HEIGHT_LEN + 60);
        setTitle("DrawShape");
        framePanel.setLayout(new BorderLayout());

        startButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        endButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);

        componentPanel.setSize(OffsetUtil.WIDTH_LEN, 60);
        componentPanel.add(scoreBoard);
        componentPanel.add(startButton);
        componentPanel.add(endButton);
        componentPanel.add(timeHint);
        componentPanel.add(timeSelector);
        canvas.setBackground(Color.WHITE);

        framePanel.add(canvas, BorderLayout.CENTER);
        framePanel.add(componentPanel, BorderLayout.SOUTH);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getEndButton() {
        return endButton;
    }

    public JTextPane getScoreBoard() {
        return scoreBoard;
    }

    public JComboBox<String> getTimeSelector() {
        return timeSelector;
    }

    public JPanel getCanvas() {
        return canvas;
    }

}
