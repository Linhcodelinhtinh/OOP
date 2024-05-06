package OOP.game;

import OOP.Needed_Library.StdOut;
import OOP.game.state.GameStateManager;
import OOP.game.util.KeyHandler;
import OOP.game.util.MouseHandler;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {
    public static int width;
    public static int height;

    private MouseHandler mouse;
    private KeyHandler key;

    private Thread thread;
    private BufferedImage image;
    private Graphics2D graphics;
    private boolean is_running = false;

    private GameStateManager gsm;
    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocusInWindow();
    }

    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    public void initialize() {
        is_running = true;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = (Graphics2D) image.getGraphics();
        mouse = new MouseHandler(this);
        key = new KeyHandler(this);
        gsm = new GameStateManager();
    }

    public void run() {
        initialize();
        final double standardRefreshRate = 60.0;
        final double TBU = 1e9 / standardRefreshRate; // Time before update

        int NeededUpdates = 5;

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60.0;
        final double TTBU = 1e9 / TARGET_FPS; // Total time before update

        int frames = 0;
        int previousFrames = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1e9);
        while (is_running) {
            double currentTime = System.nanoTime();
            int made_updates = 0;
            while ((made_updates < NeededUpdates) && (currentTime - lastUpdateTime > TBU)) {
                update();
                input(mouse, key);
                lastUpdateTime += TBU;
                made_updates++; // do increment on the number of updates that have been made
            }
            if(currentTime - lastUpdateTime > TBU) {
                lastUpdateTime = currentTime - TBU;
            }

            input(mouse, key);
            render();
            draw();
            lastRenderTime = currentTime;
            frames += 1;

            int thisSecond = (int) ((lastUpdateTime) / 1e9);
            if(thisSecond > lastSecondTime) {
                if(frames != previousFrames) {
                    System.out.println("Second: " + thisSecond + " FPS:" + frames);
                    previousFrames = frames;
                }
                frames = 0;
                lastSecondTime = thisSecond;
            }
            while(currentTime - lastRenderTime < TTBU && currentTime - lastUpdateTime < TBU)
            {
                Thread.yield();
                try{
                    Thread.sleep(1); // is that really necessary ?

                } catch(InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
                currentTime = System.nanoTime();
            }
        }
    }

    public void update() {
        gsm.update();
    }
    public void input(MouseHandler mouse, KeyHandler key) {
        gsm.input(mouse, key);
    }
    public void render() {
        if(graphics != null) {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
        }
        gsm.render(graphics);
    }

    public void draw() {
        Graphics graphics2 = this.getGraphics();
        graphics2.drawImage(image, 0, 0, width, height, null);
        graphics2.dispose();
    }
}
