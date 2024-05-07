package OOP.game.instance;

import OOP.game.graphics.Sprite;
import OOP.game.util.KeyHandler;
import OOP.game.util.MouseHandler;
import OOP.game.util.Vector2D;

import java.awt.*;

public class Player extends Entity{

    public Player(Sprite sprite, Vector2D vec, int size){
        super(sprite, vec, size);
    }

    public void update(){
        super.update();
        move();
    }
    @Override
    public void render(Graphics2D g) {

    }

    public void input(MouseHandler mouse, KeyHandler key) {
        if(key.up.down){
            up = true;
        }
        else
            up = false;
        if(key.down.down){
            down = true;
        }
        else
            down = false;
        if(key.left.down){
            left = true;
        }
        else
            left = false;
        if(key.right.down){
            right = true;
        }
        else
            right = false;
        if(key.attack.down){
            attack = true;
        }

        if(mouse.getButton()==1){
            System.out.println();
        }
    }

    public void move(){
        if(up){
            dy -= acceleration;
            if(dy <- maxSpeed){
                dy = -maxSpeed;
            }
        }
        else{
            if(dy<0){
                dy+=deceleration;
                if(dy > 0){
                    dy = 0;
                }
            }
        }
        if(down){
            dy += acceleration;
            if(dy > maxSpeed){
                dy = maxSpeed;
            }
            else{
                if(dy>0){
                    dy -= deceleration;
                    if(dy <- maxSpeed){}
                }
            }
        }
        else{

        }
        if(left){

        }
        else{

        }
        if(right){

        }
        else{

        }

    }

//    private int HP;
//    private int maxHP;
//    private int xp;
//    public static int atk;
//    public static int def;
//    public static int lvl;
//    public static int numPotions;
//    public static String name;
//
//    Player(int x, int y, int z){
//        this.HP = x;
//        this.maxHP = y;
//        this.xp = z;
//    }
//    /* Getters & Setters */
//    public int getHp(){
//        return this.HP;
//    }
//    public void setHP(int hp){
//        HP = hp;
//    }
//
//    // ... any other ones you need
}
