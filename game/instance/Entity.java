package OOP.game.instance;

import OOP.game.graphics.Animation;
import OOP.game.graphics.Sprite;
import OOP.game.util.KeyHandler;
import OOP.game.util.MouseHandler;
import OOP.game.util.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    private final int UP = 3;
    private final int DOWN = 2;
    private final int LEFT = 1;
    private final int RIGHT = 0;

    protected Animation move;
    protected Sprite sprite;
    protected Vector2D position;
    protected int size;
    protected int currentAnimation;

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;

    protected int attack;
    protected int attackSpeed;
    protected int timePerAttack;
    protected double maxSpeed;
    protected double acceleration;
    protected double deceleration;
    protected double dx;
    protected double dy;




    public Entity(Sprite sprite, Vector2D vec, int size) {
        this.sprite = sprite;
        position = vec;
        this.size = size;

//        move = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        move.setFrames(frames);
        move.setDelay(delay);
    }
    public void animate(){
        if(up){
            if(currentAnimation != UP || move.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP), 3);
            }
        }
        else if(down){
            if(currentAnimation != DOWN || move.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 3);
            }
        }
        else if(left){
            if(currentAnimation != LEFT || move.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 3);
            }
        }
        else if(right){
            if(currentAnimation != RIGHT || move.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 3);
            }
        }
        else{
            // animation when stop
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), 3);
        }
    }
    public double getSize(){
        return size;
    }
    public void update(){
        animate();
//        setHitBox();
        move.update();
    }


    public abstract void render(Graphics2D g);
    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {

    }
}
