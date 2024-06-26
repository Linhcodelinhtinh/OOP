package OOP.game;

import OOP.game.enviroment_effects.EnvironmentManager;
import OOP.game.event.EventHandler;
import OOP.game.instance.Player;
import OOP.game.map.Collision;
import OOP.game.map.tiles.BlockManager;
import OOP.game.util.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //set screen size
    final int orTileSize = 16;
    final int scale = 3;
    public final int tileSize = orTileSize * scale; // also charater size
    public final int screenCol = 32;
    public final int screenRow = 16;
    public final int screenWidth = screenCol * tileSize;
    public final int screenHeight = screenRow * tileSize;
    // set up stuffs
    final int FPS = 60;
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler(this);
    public Player player = new Player(this, keyHandler);
    public BlockManager blockManager = new BlockManager(this);
    public Collision collision = new Collision(this);
    public EventHandler eventHandler = new EventHandler(this);
    EnvironmentManager environmentManager = new EnvironmentManager(this);
//    public SuperClass[] objectx = new SuperClass[10];
//    objectx[1] = new obj_HP;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        double drawInterval = 1e9/FPS; // time needed to draw a frame, about 0,008(3)s
        double nextDrawTime = System.nanoTime() + drawInterval;
        long currentTime = System.nanoTime();

        while(gameThread.isAlive()){
            // update game information
            update();
            // redraw things
            repaint();
            try {
                double deltaTime = nextDrawTime - System.nanoTime();
                deltaTime /= 1e6; // convert deltaTime appropriate data type "long milis"

                if(deltaTime < 0){
                    deltaTime = 0;
                }
                Thread.sleep((long) deltaTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        player.update();
        environmentManager.light.update(120);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        blockManager.draw(g2d);
//        HPManager.draw(g2d);
        player.draw(g2d);
        environmentManager.draw(g2d);
        g2d.dispose();
    }


}
