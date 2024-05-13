package OOP.game.instance;

import OOP.game.GamePanel;
import OOP.game.util.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int speed;
    public String direction;

    BufferedImage r1, r2, r3, r4, r5, l1, l2, l3, l4, l5, u1, u2, u3, u4, u5, d1, d2, d3, d4, d5;

    public int spriteCount = 0;
    public int spriteNum = 1;

    public Rectangle bounds;
    public Rectangle defaultBounds;
    public boolean collide = true;

    public int maxHP;
    public int currentHP;

//    private final int UP = 3;
//    private final int DOWN = 2;
//    private final int LEFT = 1;
//    private final int RIGHT = 0;
//
//    protected Animation move;
//    protected Sprite sprite;
//    protected Vector2D position;
//    protected int size;
//    protected int currentAnimation;
//
//    protected boolean up;
//    protected boolean down;
//    protected boolean left;
//    protected boolean right;
//    protected boolean attack;
//
//    protected int attackSpeed;
//    protected int timePerAttack;
//    protected double maxSpeed = 3f;
//    protected double acceleration = 2f;
//    protected double deceleration = 0.2f;
//    protected double dx;
//    protected double dy;
//    protected CollisionProcess hitBounds;
//    protected CollisionProcess bounds;


//    public Entity(gamePanel, keyHandler) {
//        this.gamePanel = gamePanel;
//        this.keyHandler = keyHandler;
//    }

//    public Animation getMove() {
//        return move;
//    }
//    public CollisionProcess getBounds(){
//        return bounds;
//    }

//    public void setAnimation(int i, BufferedImage[] frames, int delay) {
//        currentAnimation = i;
//        move.setFrames(frames);
//        move.setDelay(delay);
//    }
//    public void setSprite(Sprite sprite) {
//        this.sprite = sprite;
//    }
//    public void setSize(int temp){
//        size = temp;
//    }
//    public void setMaxSpeed(double maxSpeed) {
//        this.maxSpeed = maxSpeed;
//    }
//    public void setAcceleration(double acceleration) {
//        this.acceleration = acceleration;
//    }
//    public void setDeceleration(double deceleration) {
//        this.deceleration = deceleration;
//    }
//
//
//    public void animate(){
//        if(up){
//            if(currentAnimation != UP || move.getDelay() == -1) {
//                setAnimation(UP, sprite.getSpriteArray(UP), 3);
//            }
//        }
//        else if(down){
//            if(currentAnimation != DOWN || move.getDelay() == -1) {
//                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 3);
//            }
//        }
//        else if(left){
//            if(currentAnimation != LEFT || move.getDelay() == -1) {
//                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 3);
//            }
//        }
//        else if(right){
//            if(currentAnimation != RIGHT || move.getDelay() == -1) {
//                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 3);
//            }
//        }
//        else{
//            // animation when stop
//            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), 3);
//        }
//    }
//    public double getSize(){
//        return size;
//    }
//    private void setHitBox(){
//        if(up){
//            hitBounds.setyOffset(-size/2);
//            hitBounds.setxOffset(-size/2);
//        }
//        else if(down){
//            hitBounds.setyOffset(size/2);
//            hitBounds.setxOffset(-size/2);
//        }
//        else if(left){
//            hitBounds.setxOffset(-size);
//            hitBounds.setyOffset(0);
//        }
//        else if(right){
//            hitBounds.setxOffset(0);
//            hitBounds.setyOffset(0);
//        }
//    }
//    public void update(double time){
//        animate();
//        setHitBox();
//        move.update();
//    }
//
//
//    public abstract void render(Graphics g);
//    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {
//    }
}
