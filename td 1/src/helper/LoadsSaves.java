package helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadsSaves {
    public static BufferedImage getSpriteAtlas(){
        BufferedImage img=null;
        InputStream is = LoadsSaves.class.getClassLoader().getResourceAsStream("/res/spriteatlas.png");
        try{
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
}
