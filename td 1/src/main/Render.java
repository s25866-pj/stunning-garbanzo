package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Render {
    private GameScreen gameScreen;
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;

    public Render(GameScreen gameScreen){
        this.gameScreen = gameScreen;
        random=new Random();
        importImg();
        loadSprites();
    }
    public final void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/spriteatlas.png");
        try{
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void render(Graphics g){
        switch (GameStates.gameStates){
            case MENU:
                for(int i=0; i<20;i++){
                    for(int j=0;j<20;j++){
                        g.drawImage(sprites.get(getRndInt()),j*32,i*32,null);
                    }
                }
                break;
            case PLAYNIG:
                break;
            case SETTINGS:
                break;
        }

    }
    private void loadSprites(){
        for(int i=0;i<2;i++){
            for(int j=0;j<10;j++){
            sprites.add(img.getSubimage(j * 32,i * 32,32,32));
            }
        }
    }
private int getRndInt(){
        return random.nextInt(20);
}
}
