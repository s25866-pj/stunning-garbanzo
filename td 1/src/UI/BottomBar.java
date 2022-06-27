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
    private Tile selectedTile;
//    =============================================================================
    public BottomBar(int x, int y, int width, int heigth, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height=height;
        this.playing=playing;
        initButtons();
    }
    private void initButtons(){
        //wielkość kafetlków wyboru{
        int w=50;
        int h=50;
        int xStart=110;
        int yStart=650;
        int xOffset=(int)(w*1.1f);
        //}
        bMenu=new MyButton("Menu",2,642,100,30);
        int i=0;
        // generowanie obrazków które wyswitlają się w wyborze kafelek
        for(Tile tile : playing.getTileManager().tiles){
            tileButtons.add(new MyButton(tile.getName(),xStart+xOffset*i,yStart,w,h,i));
            i++;
        }
    }
    private void drawButtons(Graphics g){
        bMenu.draw(g);
        drawTileButtons(g);
        drawSelectedTile(g);

    }
    private void drawSelectedTile(Graphics g) {
        if(selectedTile!=null){
            g.drawImage(selectedTile.getSprite(),550,650,70,70,null);
            g.setColor(Color.BLACK);
            g.drawRect(550,650,70,70);
        }
    }
    private void drawTileButtons(Graphics g) {
        for(MyButton b : tileButtons){
            //obrazki
            g.drawImage(getButtImg(b.getId()),b.x,b.y,b.width,b.heigth,null);
            //generowanie ramki przycisku
            if(b.isMouseOver()){
                g.setColor(Color.GREEN);
            }else{
            g.setColor(Color.BLACK);
            }
            g.drawRect(b.x,b.y,b.width,b.heigth);
            if(b.isMousePressed()) {
                for(int i = 0;i<3;i++){
                    g.drawRect(b.x + i, b.y + i, b.width - 2*i, b.heigth - 2*i);
                }

            }
        }
    }
    public BufferedImage getButtImg(int id){return playing.getTileManager().getSprite(id);}
    public void draw (Graphics g){
        g.setColor(new Color(222,123,14));
        int height = 100;
        g.fillRect(x,y,width,height);
        drawButtons(g);
    }
    public void mouseClicked(int x, int y) {
        if(bMenu.getBounds().contains(x,y)){
            SetGameState(MENU);
        }else{
            for(MyButton b : tileButtons){
                if(b.getBounds().contains(x,y)){
                    selectedTile=playing.getTileManager().getTile(b.getId());
                    playing.setSelectedTile(selectedTile);
                    return;
                }
            }
        }
    }
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        for(MyButton b : tileButtons){
                b.setMouseOver(false);

        }
        if(bMenu.getBounds().contains(x,y)){
            bMenu.setMouseOver(true);
        }else{
            for(MyButton b : tileButtons){
                if(b.getBounds().contains(x,y)){
                    b.setMouseOver(true);
                    return;
                }
            }
        }

    }
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMousePressed(true);
        }else{
            for(MyButton b : tileButtons){
                if(b.getBounds().contains(x,y)){
                b.setMousePressed(true);
                return;}
            }
        }
    }
    public void mouseReleased(int x, int y) {
        resetButtons();
    }
    private void resetButtons() {
        bMenu.resetBooleans();
        for(MyButton b : tileButtons){
            b.resetBooleans();
        }
    }
}
