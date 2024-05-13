package OOP.game.map.objects;

import OOP.game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;


//THIS CLASS IS TO DISPLAY PLAYER HP IN THE OLDER CONCEPT BUT NOW THE GAME CHANGE TO FIND WAY OUT
public abstract class obj_HP extends SuperClass {
    GamePanel gamePanel;

    public obj_HP (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        name = "Heart";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("OOP/game/resources/player/health_point/heart_blank.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("OOP/game/resources/player/health_point/heart_full.png")));
            image3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("OOP/game/resources/player/health_point/heart_half.png")));

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2d) {
        g2d.drawImage(image, 48, 48, null);
        g2d.drawImage(image2, 48, 48, null);
        g2d.drawImage(image3, 48, 48, null);
    }
}
