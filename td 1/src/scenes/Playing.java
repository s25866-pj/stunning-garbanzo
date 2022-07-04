package scenes;

import UI.BottomBar;
import helper.LevelBuild;
import helper.LoadSaves;
import main.Game;
import managers.TileManager;
import objects.Tile;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Playing extends GameScene implements SceneMethods {
    private int [][] lvl;
    private TileManager tileManager;
    private Tile selectedTile;
    private int mouseX,mouseY;
    private int lastTileX,lastTileY,lastTileId;
    private boolean drawSelect;

    private BottomBar bottomBar;
    public Playing(Game game) {
        super(game);

        lvl = LevelBuild.getLevelData();
        tileManager=new TileManager();
        bottomBar=new BottomBar(0,640,640,100,this);

        //LoadSaves.CreateFile();
        //LoadSaves.WriteToFile();
        //LoadSaves.ReadFromFile();
        //File lvlFile = new File("td 1/src/res/"+name+".txt");
        loadDefaultLevel();
        //createDefaultLevel();

    }

    private void loadDefaultLevel() {
        lvl=LoadSaves.GetLevelData("new_level");
    }
    public void saveLevel(){
        LoadSaves.SaveLevel("new_level",lvl);
    }

    private void createDefaultLevel() {
        int[] arr = new int[400];
        for (int i =0; i<arr.length;i++){
            arr[i]=0;
        }
        LoadSaves.CreateLevel("new_level",arr);
    }

    @Override
    public void render(Graphics g) {
        for(int i= 0;i<lvl.length;i++){
            for(int j=0;j<lvl[i].length;j++){
                int id=lvl[i][j];
                g.drawImage(tileManager.getSprite(id),j*32,i*32,null);
            }
        }

        bottomBar.draw(g);
        drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g) {
        if(selectedTile !=null && drawSelect){
            g.drawImage(selectedTile.getSprite(),mouseX,mouseY,32,32,null);
        }
    }
    public void setSelectedTile(Tile tile){
        this.selectedTile=tile;
        drawSelect = true;
    }
    public TileManager getTileManager(){
        return tileManager;
    }
    @Override
    public void mouseClicked(int x, int y) {
        if(y>=640){
            bottomBar.mouseClicked(x,y);
        }else{
            changeTitle(mouseX,mouseY);
        }
    }

    private void changeTitle(int x, int y) {
        if(selectedTile!=null){
            int tileX=x/32;
            int tileY=y/32;
            if(lastTileX==tileX && lastTileY==tileY && lastTileId==selectedTile.getId()){
                return;
            }
            lastTileX=tileX;
            lastTileY=tileY;
            lastTileId=selectedTile.getId();
            lvl[tileY][tileX]=selectedTile.getId();

        }


    }

    @Override
    public void mouseMoved(int x, int y) {
        if(y>=640){
            bottomBar.mouseMoved(x,y);
            drawSelect = false;
        }else{
            drawSelect = true;
            mouseX=(x/32)*32;
            mouseY=(y/32)*32;
        }
    }
    @Override
    public void mousePressed(int x, int y) {
        if(y>=640){
            bottomBar.mousePressed(x,y);
        }else{
            changeTitle(mouseX,mouseY);
        }
    }
    @Override
    public void mouseReleased(int x, int y) {
            bottomBar.mouseReleased(x,y);
    }

    @Override
    public void mouseDragged(int x, int y) {
        if(y>=640){

        }else{
            changeTitle(x,y);
        }
    }

}
