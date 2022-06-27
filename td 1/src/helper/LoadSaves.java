package helper;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
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
    public static BufferedImage Create_blank_File(){
//    File blank_page=new File("/home/damian/Desktop/New Folder/stunning-garbanzo/td 1/src/res/test.txt");
//    close(blank_page);
        return null;
    }
}
