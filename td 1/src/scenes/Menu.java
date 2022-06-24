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
        int w=150;
        int h=w/3;
        int x=640/2 - w/2;
        int y=150;
        int yOffset=100;

        bPlay = new MyButton("Play",x,y,w,h);
        bSetting=new MyButton("Settings(not working)",x,y+yOffset,w,h);
        bQuit=new MyButton("Quit",x,y+yOffset*2,w,h);

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
        } else if (bSetting.getBounds().contains(x,y)) {
            SetGameState(SETTINGS);
        } else if (bQuit.getBounds().contains(x,y)) {
            System.exit(0);
        }

    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlay.setMouseOver(false);
        bSetting.setMouseOver(false);
        bQuit.setMouseOver(false);
        if(bPlay.getBounds().contains(x,y)){
            bPlay.setMouseOver(true);
        } else if(bSetting.getBounds().contains(x,y)){
            bSetting.setMouseOver(true);
        }else if(bQuit.getBounds().contains(x,y)){
            bQuit.setMouseOver(true);
        }
    }
    private void drawButtons (Graphics g){
        bPlay.draw(g);
        bSetting.draw(g);
        bQuit.draw(g);
    }
    public void importImg () {
        InputStream is = getClass().getResourceAsStream("/res/spriteatlas.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void mousePressed(int x, int y) {
        if (bPlay.getBounds().contains(x, y)) {
            bPlay.setMousePressed(true);
        }else if(bSetting.getBounds().contains(x,y)){
            bSetting.setMousePressed(true);}
        else if(bQuit.getBounds().contains(x,y)){
            bQuit.setMousePressed(true);}
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlay.resetBooleans();
        bSetting.resetBooleans();
        bQuit.resetBooleans();
    }
}

