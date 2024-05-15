package OOP.game.instance;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;
    public String direction;

    BufferedImage r1, r2, r3, r4, r5, l1, l2, l3, l4, l5, u1, u2, u3, u4, u5, d1, d2, d3, d4, d5;
    BufferedImage endGame, nextMap;
    public int spriteCount = 0;
    public int spriteNum = 1;

    public Rectangle bounds;
    public Rectangle defaultBounds;
    public boolean collide = true;

    public int maxHP;
    public int currentHP;
}
