package main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameScreen extends JPanel {
    private Dimension size;
    private Random random;
    private Render render;

    public GameScreen(){
        random = new Random();
        render = new Render(this);
        setPanelSize();
    }

    private void setPanelSize() {
        size = new Dimension(800,800);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);

      for(int i=0; i<20; i++){
          for(int j=0; j<20; j++) {
              g.setColor(getRndColor());
              g.fillRect(i * 40, j * 40, 40, 40);
          }
      };

      //repaint();

    }

    private Color getRndColor(){
        int r= random.nextInt(256);
        int g=random.nextInt(256);
        int b=random.nextInt(256);
        return new Color(r,g,b);
    }

}
