package scenes;

import UI.MyButton;
import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import static main.GameStates.*;


public class Menu extends GameScene implements SceneMethods{
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;
    private MyButton bPlay, bSetting, bQuit;
    public Menu(Game game) {
        super(game);
//        importImg();
//        loadSprites();
        initButtons();
        random=new Random();
    }

    private void initButtons() {
        bPlay = new MyButton("Play",100,100,100,50);
    }

    private void loadSprites() {
    }

    @Override
    public void render(Graphics g) {
        drawButtons(g);
    }
    @Override
    public void mouseClicked(int x, int y) {
        if(bPlay.getBounds().contains(x,y)){
            SetGameState(PLAYING);
        }

    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlay.setMouseOver(false);
        if(bPlay.getBounds().contains(x,y)){
            bPlay.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bPlay.getBounds().contains(x, y)) {
            bPlay.setMousePressed(true);
        }

        private void drawButtons (Graphics g){
            bPlay.draw(g);
        }

        public void importImg () {
            InputStream is = getClass().getResourceAsStream("/res/spriteatlas.png");
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

