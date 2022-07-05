package main;
import scenes.Playing;

import java.awt.*;

public class Render {
    private Game game;


    public Render(Game game){
        this.game=game;


    }

    public void render(Graphics g){
        System.out.println(Playing.lvl);
        switch (GameStates.gameStates){
            case MENU:
                game.getMenu().render(g);
                break;
            case PLAYING:
                game.getPlaying().render(g);
                break;
            case SETTINGS:
                game.getSettings().render(g);
                break;
        }

    }
}

