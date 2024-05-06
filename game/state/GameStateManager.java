package OOP.game.state;

import OOP.game.GamePanel;
import OOP.game.util.KeyHandler;
import OOP.game.util.MouseHandler;
import OOP.game.util.Vector2D;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
    private ArrayList<GameState> states;

    public static Vector2D map;

    public static final int START = 0;
    public static final int MENU = 1;
    public static final int PAUSE = 2;
    public static final int END = 3;

    public GameStateManager(){
        map = new Vector2D(GamePanel.width, GamePanel.height);
        Vector2D.setWorldVar(map.x, map.y);
        states = new ArrayList<GameState>();
        states.add(new PlayState(this));
    }

    public void pop(int state){
        states.remove(state);
    }

    public void add(int state){
        if(state == START){
            states.add(new PlayState(this));
        }
        else if(state == MENU){
            states.add(new MenuState(this));
        }
        else if(state == PAUSE){
            states.add(new PauseState(this));
        }
        else if(state == END){
            states.add(new EndState(this));
        }
    }

    public void popAndAdd(int state){
        states.remove(state);
        add(state);
    }

    public void update(){
        Vector2D.setWorldVar(map.x, map.y);
        for (GameState state : states) {
            state.update();
        }
    }
    public void input(MouseHandler mouse, KeyHandler key){
        for (GameState state : states) {
            state.input(mouse, key);
        }
    }

    public void render(Graphics2D g){
        for (GameState state : states) {
            state.render(g);
        }
    }
}
