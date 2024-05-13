package OOP.game.map.objects;

import OOP.game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;


// SHOULDN'T WORK SO SHOULDN'T BE CALLED
public abstract class SuperClass {

    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int x, y;
    public Rectangle bounds = new Rectangle(0, 0, 48, 48);
    public int boundsX = bounds.x;
    public int boundsY = bounds.y;

    public void draw(Graphics2D g2d, GamePanel gamePanel) {

    }

}
