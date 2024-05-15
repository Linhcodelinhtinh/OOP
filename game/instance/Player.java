package OOP.game.instance;

import OOP.game.GamePanel;
import OOP.game.util.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    protected GamePanel gamePanel;
    public KeyHandler keyHandler;
    public String state;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValue();
        getPlayerImage();
        bounds = new Rectangle(8, 16, 32, 24);
        defaultBounds = new Rectangle(8, 16, 32, 24);
    }

    public void setDefaultValue() {
        // start position and status
        x = 28 * 48; //testing case
        y = 14 * 38;
//        x = 100; // exact starting point
//        y = 100;
        speed = 3;
        direction = "right";
        maxHP = 6;
        currentHP = maxHP;
        state = "play";
    }

    public void getPlayerImage() {
        try {
            u1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_u1.png")));
            u2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_u2.png")));
            u3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_u3.png")));
            u4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_u4.png")));
            u5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_u5.png")));
            d1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_d1.png")));
            d2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_d2.png")));
            d3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_d3.png")));
            d4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_d4.png")));
            d5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_d5.png")));
            r1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_r1.png")));
            r2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_r2.png")));
            r3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_r3.png")));
            r4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_r4.png")));
            r5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_r5.png")));
            l1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_l1.png")));
            l2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_l2.png")));
            l3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_l3.png")));
            l4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_l4.png")));
            l5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/player/movements/Character_l5.png")));
            endGame = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/state/endGame.png")));
            nextMap = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/OOP/game/resources/state/nextMap.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void move(){
        if (keyHandler.up.down) { // "down" means the button get pressed
            direction = "up";
        }
        if (keyHandler.down.down) {
            direction = "down";
        }
        if (keyHandler.left.down) {
            direction = "left";
        }
        if (keyHandler.right.down) {
            direction = "right";
        }

        if (keyHandler.down.down || keyHandler.up.down || keyHandler.left.down || keyHandler.right.down) {
            spriteCount++;
            if (spriteCount > 6) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 5;
                } else if (spriteNum == 5) {
                    spriteNum = 1;
                }
                spriteCount = 0;
            }
            collide = false;
            gamePanel.collision.checkCollision(this);

            gamePanel.eventHandler.eventChecker();
            if (!collide) {
                if (Objects.equals(direction, "up"))
                    y -= speed;
                if (Objects.equals(direction, "left"))
                    x -= speed;
                if (Objects.equals(direction, "right"))
                    x += speed;
                if (Objects.equals(direction, "down"))
                    y += speed;
            }
        } else {
            spriteNum = 1;
        }
    }
    public void update() {
        if (x >= 16.5 * 48 && x <= 18 * 48 && y >= 4.5 * 48 && y <= 6 * 48) {
            x = gamePanel.tileSize * 23;
            y = gamePanel.tileSize * 11;
        }
        if (x >= 27 * 48 && x <= 28.3 * 48 && y >= 13.5 * 48 && y <= 15 * 48) {
            x = gamePanel.tileSize * 29;
            y = gamePanel.tileSize * 3;
        }
        if (x >= 25 * 48 && x <= 26.5 * 48 && y >= 13.5 * 48 && y <= 15 * 48) {
            x = gamePanel.tileSize * 29;
            y = gamePanel.tileSize * 3;
        }
        if (keyHandler.enter.down && (x >= 28.5 * 48 && x <= 31 * 48 && y >= 12.5 * 48 && y <= 15 * 48)) {
            direction = "right";
            state = "end";
        }
        if(keyHandler.space.down) {
            if(Objects.equals(state, "end")){
                gamePanel.blockManager.loadMap("/OOP/game/resources/maps/map2.txt");
                System.out.println("map2 loaded successfully");
                setDefaultValue();
                state = "play";
            }
        }
        if(state.equals("play")) {
            move();
        }
    }

    public void draw(Graphics2D g2d) {
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        if (Objects.equals(state, "end")) {
            g2d.drawImage(endGame, 9 * 48, 4 * 48, null);
            g2d.drawImage(nextMap, 12 * 48, 8 * 48, null);
        } else {
            BufferedImage image = null;
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = u1;
                    } else if (spriteNum == 2) {
                        image = u2;
                    } else if (spriteNum == 3) {
                        image = u3;
                    } else if (spriteNum == 4) {
                        image = u4;
                    } else if (spriteNum == 5) {
                        image = u5;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = d1;
                    } else if (spriteNum == 2) {
                        image = d2;
                    } else if (spriteNum == 3) {
                        image = d3;
                    } else if (spriteNum == 4) {
                        image = d4;
                    } else if (spriteNum == 5) {
                        image = d5;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = l1;
                    } else if (spriteNum == 2) {
                        image = l2;
                    } else if (spriteNum == 3) {
                        image = l3;
                    } else if (spriteNum == 4) {
                        image = l4;
                    } else if (spriteNum == 5) {
                        image = l5;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = r1;
                    } else if (spriteNum == 2) {
                        image = r2;
                    } else if (spriteNum == 3) {
                        image = r3;
                    } else if (spriteNum == 4) {
                        image = r4;
                    } else if (spriteNum == 5) {
                        image = r5;
                    }
                    break;
            }
            g2d.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
