package inputs;

import main.GameStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static main.GameStates.*;

public class KeyboardListner implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A) {
            GameStates.gameStates = MENU;
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            GameStates.gameStates = PLAYING;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            GameStates.gameStates = SETTINGS;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
