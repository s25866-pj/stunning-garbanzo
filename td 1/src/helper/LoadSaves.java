package helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSaves {
    public static BufferedImage getSpriteAtlas(){
        BufferedImage img =null;
        InputStream is = LoadSaves.class.getClassLoader().getResourceAsStream("res/spriteatlas.png");
        try{
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
}
