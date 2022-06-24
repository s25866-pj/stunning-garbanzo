package UI;

import java.awt.*;

public class MyButton {
    private String text;
    private int x,y,width,height;

    private Rectangle bounds;
    private boolean mouseOver, mousePressed;
    public MyButton(String text,int x,int y,int width, int height){
        this.text=text;
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        initBounds();
    }
    private void initBounds(){
        this.bounds= new Rectangle(x,y,width,height);
    }
    public void draw(Graphics g){
        drawBody(g);

        drawBorder(g);

        drawText(g);

    }

    private void drawBorder(Graphics g) {
        if(mousePressed){
            g.setColor(Color.BLACK);
            g.drawRect(x+1, y+1, width-2, height-2);
            g.drawRect(x+2, y+2, width-4, height-4);
        }else {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
        }

    }

    private void drawBody(Graphics g) {
        if(mouseOver){
            g.setColor(Color.DARK_GRAY);
        }else{
            g.setColor(Color.WHITE);
            g.fillRect(x,y,width,height);
        }

    }
    public void setMousePressed(boolean mousePressed){
        this.mousePressed=mousePressed;
    }
    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(text,x-w/2 +width/2,y+h/2+height/2);
    }
    public void setMouseOver(boolean mouseOver){
        this.mouseOver=mouseOver;
    }
    public Rectangle getBounds(){
        return bounds;
    }
}
