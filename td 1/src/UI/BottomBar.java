package UI;

import objects.Tile;
import scenes.Playing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static main.GameStates.MENU;
import static main.GameStates.SetGameState;

public class BottomBar {
    public int x,y, width,height;
    private MyButton bMenu;
    private Playing playing;
    private ArrayList<MyButton> tileButtons = new ArrayList<>();

    public BottomBar(int x, int y, int width, int heigth, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height=height;
        this.playing=playing;
        initButtons();
    }
    private void initButtons(){
        int w=50;
        int h=50;
        int xStart=110;
        int yStart=650;
        int xOffset=(int)(w*1.1f);

        bMenu=new MyButton("Menu",2,642,100,30);
        int i=0;
        for(Tile tile : playing.getTileManager().tiles){
            tileButtons.add(new MyButton(tile.getName(),xStart+xOffset*i,yStart,w,h,i));
            i++;
        }
    }
    private void drawButtons(Graphics g){
        bMenu.draw(g);
        drawTileButtons(g);

    }
    private void drawTileButtons(Graphics g) {
        for(MyButton b : tileButtons){
            g.drawImage(getButtImg(b.getId()),b.x,b.y,b.width,b.heigth,null);
        }
    }
    public BufferedImage getButtImg(int id){return playing.getTileManager().getSprite(id);}
    public void draw (Graphics g){

        g.setColor(new Color(222,123,14));
        g.fillRect(x,y,width,height);
        drawButtons(g);
    }

    public void mouseClicked(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            SetGameState(MENU);
        }
    }
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMouseOver(true);
        }

    }
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMousePressed(true);
        }
    }
    public void mouseReleased(int x, int y) {
        resetButtons();
    }
    private void resetButtons() {
        bMenu.resetBooleans();
    }
}
