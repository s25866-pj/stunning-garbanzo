package managers;
import helper.LoadSaves;
import objects.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager {
public Tile GRASS,WATER,ROAD,CORNER,END;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles=new ArrayList<>();
    public TileManager(){
    loadAtlas();
    createTiles();
    }

    private void createTiles() {
        int id=0;
        tiles.add(GRASS=new Tile(getSprite(9,0),id++,"Grass") );
        tiles.add(WATER=new Tile(getSprite(0,0),id++,"Water") );
        tiles.add(ROAD=new Tile(getSprite(8,0),id++,"Road") );
        tiles.add(CORNER=new Tile(getSprite(7,0),id++,"Corner") );
        tiles.add(END=new Tile(getSprite(9,2),id++,"End") );

    }
    private void loadAtlas() {
        atlas= LoadSaves.getSpriteAtlas();
    }
    public Tile getTile(int id){
        return tiles.get(id);
    }
    public BufferedImage getSprite(int id){
            return tiles.get(id).getSprite();
    }
    private BufferedImage getSprite(int XCord, int YCord){
        return atlas.getSubimage(XCord*32,YCord*32,32,32);
    }
}