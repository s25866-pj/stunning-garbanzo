package managers;
import helper.LoadSaves;
import objects.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {
    public Tile GRASS,WATER,ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles=new ArrayList<>();
    public TileManager(){
    loadAtlas();
    createTiles();
    }

    private void createTiles() {
        tiles.add(GRASS=new Tile(getSprite(9,0)) );
        tiles.add(WATER=new Tile(getSprite(0,0)) );
        tiles.add(ROAD=new Tile(getSprite(8,0)) );
    }
    private void loadAtlas() {
        atlas= LoadSaves.getSpriteAtlas();
    }
    public BufferedImage getSprite(int id){
            return tiles.get(id).getSprite();
    }
    private BufferedImage getSprite(int XCord, int YCord){
        return atlas.getSubimage(XCord*32,YCord*32,32,32);
    }
}
