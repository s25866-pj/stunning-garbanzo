package main;

import java.awt.*;

public class Render {
    private GameScreen gameScreen;

    public Render(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void render(Graphics g){


    switch (GameStates.gameStates){
        case MENU:
            break;
        case PLAYNIG:
            break;
        case SETTINGS:
            break;
    }

    }
//    private void loadSprites(){
//        for(int i=0;i<10;i++){
//            for(int j=0;j<10;j++){
////            sprites.add()img.getSubimage(j*32,i*32,32,32);
//            }
//        }
//    }
//private int getRndInt(){
//        return random.nextInt(100);
//}
}
