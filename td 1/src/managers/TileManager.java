package managers;

import helper.LoadsSaves;
import objects.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {
    public Tile GRASS,WATER,ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles=new ArrayList<>();
    public TileManager(){
    loadAtlas();
    createTitles();
    }

    private void createTitles() {
        tiles.add(GRASS=new Tile(getSprite(10,0)) );
        tiles.add(WATER=new Tile(getSprite(1,0)) );
        tiles.add(ROAD=new Tile(getSprite(9,1)) );
    }
    private void loadAtlas() {
        atlas= LoadsSaves.getSpriteAtlas();
    }
public BufferedImage getSprite(int id){
        return tiles.get(id).getSprite();
}
    private BufferedImage getSprite(int XCord, int YCord){
        return atlas.getSubimage(XCord*32,YCord*32,32,32);
    }
}
