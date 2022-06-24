package scenes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Menu extends GameScene implements SceneMethods{
    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;
    public Menu(main.game game) {
        super(game);
        importImg();
        loadSprites();
        random=new Random();
    }

    @Override
    public void render(Graphics g) {
        for(int i=0; i<20;i++){
            for(int j=0;j<20;j++){
                g.drawImage(sprites.get(getRndInt()),j*32,i*32,null);
            }
        }
    }
    public final void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/spriteatlas.png");
        try{
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

