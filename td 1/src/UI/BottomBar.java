package UI;

import scenes.Playing;

import java.awt.*;

import static main.GameStates.MENU;
import static main.GameStates.SetGameState;

public class BottomBar {
    private int x,y, width,hight;
    private MyButton bMenu;
    private

    public BottomBar(int x, int y, int width, int hight, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.hight = hight;
        initButtons();
    }
    private void initButtons(){
        bMenu=new MyButton("Menu",2,642,100,30);
    }
    private void drawButtons(Graphics g){
        bMenu.draw(g);
    }
    public void draw (Graphics g){

        g.setColor(new Color(222,123,14));
        g.fillRect(x,y,width,hight);
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
