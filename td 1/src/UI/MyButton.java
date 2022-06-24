package UI;

import java.awt.*;

public class MyButton {
  public int x,y,width,heigth,id;
  public String text;

    private Rectangle bounds;
    private boolean mouseOver, mousePressed;
    public MyButton(String text,int x,int y,int width, int heigth){
        this.text=text;
        this.x=x;
        this.y=y;
        this.heigth=heigth;
        this.width=width;
        this.id=-1;
        initBounds();
    }
    public MyButton(String text,int x,int y,int width, int heigth,int id){
        this.text=text;
        this.x=x;
        this.y=y;
        this.heigth=heigth;
        this.width=width;
        this.id=id;
        initBounds();
    }
    private void initBounds(){
        this.bounds= new Rectangle(x,y,width,heigth);
    }
    public void draw(Graphics g){
        drawBody(g);
        drawBorder(g);
        drawText(g);
    }

    public int getId() {
        return id;
    }

    private void drawBorder(Graphics g) {
        if(mousePressed){
            g.setColor(Color.BLACK);
            for (int i=1; i<6;i++){
                g.drawRect(x+i, y+i, width-2*i, heigth-2*i);
            }

        }else {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, heigth);
        }

    }
    public boolean isMouseOver(){
            return mouseOver;
    }
    public boolean isMousePressed(){
            return mousePressed;
    }
    private void drawBody(Graphics g) {
        if(mouseOver){
            g.setColor(Color.DARK_GRAY);
        }else{
            g.setColor(Color.WHITE);
            g.fillRect(x,y,width,heigth);
        }

    }
    public void setMousePressed(boolean mousePressed){
        this.mousePressed=mousePressed;
    }
    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(text,x-w/2 +width/2,y+h/2+heigth/2);
    }
    public void resetBooleans(){
        this.mouseOver=false;
        this.mousePressed=false;
    }
    public void setMouseOver(boolean mouseOver){
        this.mouseOver=mouseOver;
    }
    public Rectangle getBounds(){
        return bounds;
    }
}
