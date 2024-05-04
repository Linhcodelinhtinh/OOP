package OOP.game.state;

import OOP.game.util.KeyHandler;
import OOP.game.util.MouseHandler;

import java.awt.*;

public class PlayState extends GameState{
    public static int x =0, y=0;
    public PlayState(GameStateManager gsm){
        super(/*gsm*/);
    }
    public void update(){

    }
    public void input(MouseHandler mouse, KeyHandler key){
        if(key.up.down){
            y-=1;
            System.out.println("'w' is being pressed");
        }
        if(key.down.down){
            y+=1;
            System.out.println("'s' is being pressed");
        }
        if(key.left.down){
            x-=1;
            System.out.println("'a' is being pressed");
        }
        if(key.right.down){
            x+=1;
            System.out.println("'d' is being pressed");
        }
    }
    public void render(Graphics2D g){
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 64, 64);
    }
}
