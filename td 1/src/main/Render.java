package main;

import java.awt.*;

public class Render {
    private main.game game;


    public Render(main.game game){
        this.game=game;


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
}

