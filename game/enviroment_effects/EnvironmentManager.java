package OOP.game.enviroment_effects;

import OOP.game.GamePanel;

import java.awt.*;

public class EnvironmentManager {
    GamePanel gamePanel;
    public Light light;

    public EnvironmentManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        light = new Light(gamePanel);
    }
    public void setup(){
        light = new Light(gamePanel);
    }
    public void draw(Graphics2D g2d){
        light.draw(g2d);
    }
}
