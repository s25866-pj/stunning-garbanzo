package main;
import inputs.KeyboardListner;
import inputs.MyMouseListener;

import javax.swing.JFrame;
import java.awt.event.KeyListener;

class Game extends JFrame implements Runnable{
    private final GameScreen gameScreen;
private final double FPS_SET = 120.0;
private final double UPS_SET = 60.0;

    private int updates;
    private long lastTimeUPS;

    private Thread gameThread;
private MyMouseListener myMouseListener;
private KeyListener keyListener;

    public Game(){


        this.setTitle("Jebać jave");
        this.gameScreen = new GameScreen();
        this.add(gameScreen);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pack();
//        this.setSize(800,820);
        this.setVisible(true);

    }
    private void initInputs(){
        myMouseListener = new MyMouseListener();
        keyListener = new KeyboardListner();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyListener);

        requestFocus();

    }
    private void start(){
        gameThread = new Thread(this){};
        gameThread.start();
    }


    private void updateGame(){
        updates++;
      //  System.out.println("Game updated");
    }
    private void callUPS(){
        if(System.currentTimeMillis() - lastTimeUPS>=1000){
            System.out.println("UPS: "+updates);
            updates=0;
            lastTimeUPS= System.currentTimeMillis();
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.initInputs();
        game.start();

    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0/FPS_SET;
        double timePerUpdate =1000000000.0/UPS_SET;
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;
        long now;
        while (true) {
            now = System.nanoTime();
            if(now - lastFrame >=timePerFrame){
                repaint();
                lastFrame = now;
                frames++;
            }
            if(now - lastUpdate >=timePerUpdate){
                updateGame();
                lastUpdate=now;
                updates++;

            }
            if(System.currentTimeMillis() - lastTimeCheck>=1000){
                System.out.println("FPS: "+frames+" | UPS: "+updates);
                updates=0;
                frames = 0;
                lastTimeCheck=System.currentTimeMillis();


            }
        }
    }
}
