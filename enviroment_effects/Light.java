package OOP.enviroment_effects;

import OOP.game.GamePanel;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Light {
    GamePanel gamePanel;
    BufferedImage darknessFilter;
    BufferedImage darknessFilter2;
    int centerX, centerY;
    Area screenArea = new Area(new Rectangle2D.Double(0,0, 1536, 768));
    Shape circleShape, rectangle;
    Graphics2D g2d;

    public Light(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        update(120);
    }
    public void drawDarkness(){
        darknessFilter = new BufferedImage(gamePanel.screenWidth, gamePanel.screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2d = (Graphics2D) darknessFilter.getGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fill(screenArea);
        g2d.dispose();
    }
    public void update(int lightZoneSize){
        centerX = gamePanel.player.x;
        centerY = gamePanel.player.y;

        double x = centerX - (double) lightZoneSize /2.8;
        double y = centerY - (double) lightZoneSize /2.8;

        circleShape = new Ellipse2D.Double(x,y,lightZoneSize,lightZoneSize);
        rectangle = new Rectangle2D.Double(29*48,13*48,48*2,48*2);
        screenArea = new Area(new Rectangle2D.Double(0,0, 1536, 768));
        Area lightArea = new Area(circleShape);
        Area lightArea2 = new Area(rectangle);

        screenArea.subtract(lightArea);
        screenArea.subtract(lightArea2);

        drawDarkness();
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(darknessFilter, 0, 0, null);
    }
}
