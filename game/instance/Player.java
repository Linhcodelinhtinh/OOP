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
    protected KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValue();
        getPlayerImage();
        bounds = new Rectangle(8, 16, 32, 32);
        defaultBounds = new Rectangle(8, 16, 32, 32);
    }

    public void setDefaultValue() {
        // start position and status
        x = 100;
        y = 100;
        speed = 3;
        direction = "right";
        maxHP = 6;
        currentHP = maxHP;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(x>=27*48 && x <=29*48 && y>= 13.5*48 && y <=15*48){
            x = gamePanel.tileSize*29;
            y = gamePanel.tileSize*3;
            System.out.println("You got teleport!");
        }
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
        if(keyHandler.enter.down){
            if(x >= 29*48 && x<=31*48 && y >= 13*48 && y<=15*48){
                direction = "";
                System.out.println("You win!");
            }
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
                if(Objects.equals(direction, "left"))
                    x -= speed;
                if(Objects.equals(direction, "right"))
                    x += speed;

                if(Objects.equals(direction, "down"))
                    y += speed;
            }
        } else {
            spriteNum = 1;
        }
    }

    public void draw(Graphics2D g2d) {
//        g2d.setColor(Color.BLUE);
//        g2d.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
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

//    public void update(double time) {
//        super.update(time);
////        move();
//        position.x += dx;
//        position.y += dy;
//    }

//    @Override
//    public void render(Graphics g) {
////        g.drawRect((int) (position.getWorldVar().x + bounds.getxOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
//
//        g.drawImage(move.getFrames(), (int) position.x, (int) position.y, size, size, null);
//    }

//    public void input(MouseHandler mouse, KeyHandler key) {
//        up = key.upPressed;
//        down = key.downPressed;
//        left = key.leftPressed;
//        right = key.rightPressed;
//        attack = key.spacePressed;
//
//        if (mouse.getButton() == 1) {
//        }
//    }
//
//    public void move() {
//        if (up) {
//            dy -= acceleration;
//            if (dy < -maxSpeed) {
//                dy = -maxSpeed;
//            }
//        } else {
//            if (dy < 0) {
//                dy += deceleration;
//                if (dy > 0) {
//                    dy = 0;
//                }
//            }
//        }
//        if (down) {
//            dy += acceleration;
//            if (dy > maxSpeed) {
//                dy = maxSpeed;
//            } else {
//                if (dy > 0) {
//                    dy -= deceleration;
//                    if (dy < 0) {
//                        dy = 0;
//                    }
//                }
//            }
//        }
//        if (left) {
//            dx -= acceleration;
//            if (dx < -maxSpeed) {
//                dx = -maxSpeed;
//            }
//        } else {
//            if (dx < 0) {
//                dx += deceleration;
//                if (dx > 0) {
//                    dx = 0;
//                }
//            }
//        }
//        if (right) {
//            dx += acceleration;
//            if (dx > maxSpeed) {
//                dx = maxSpeed;
//            }
//        } else {
//            if (dx > 0) {
//                dx -= deceleration;
//                if (dx < 0) {
//                    dx = 0;
//                }
//            }
//        }


//    }
}
