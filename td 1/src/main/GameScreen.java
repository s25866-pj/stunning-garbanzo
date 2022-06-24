package main;
import inputs.KeyboardListner;
import inputs.MyMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel {
    private Game game;
    private Dimension size;
    private MyMouseListener myMouseListener;
    private KeyListener keyListener;
    public GameScreen(Game game) {
        this.game = game;

        setPanelSize();
    }
    public void initInputs(){
        myMouseListener = new MyMouseListener(game);
        keyListener = new KeyboardListner();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyListener);

        requestFocus();

    }
        private void setPanelSize() {
        size = new Dimension(640,640);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        game.getRender().render(g);
    }
}