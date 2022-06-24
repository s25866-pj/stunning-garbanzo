package main;
import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private main.game game;
    private Dimension size;

    public GameScreen(main.game game) {
        this.game = game;

        setPanelSize();
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