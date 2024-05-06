package OOP.game.state;

import OOP.game.util.KeyHandler;
import OOP.game.util.MouseHandler;

import java.awt.*;

public abstract class GameState
{
    private GameStateManager gsm;
    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }
    public abstract void update();
    public abstract void input(MouseHandler mh, KeyHandler kh);
    public abstract void render(Graphics2D g);

}
