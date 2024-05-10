package OOP.temp.state;

import OOP.game.util.KeyHandler;
import OOP.temp.util.MouseHandler;
import OOP.temp.util.Vector2D;

import java.awt.*;

public class GameStateManager {
    private GameState[] states;

    public static Vector2D map;
    public static Graphics g;

    public static final int START = 0;
    public static final int MENU = 1;
    public static final int PAUSE = 2;
    public static final int END = 3;

    public GameStateManager() {
        GameStateManager.g = g;
//        map = new Vector2D(GamePanel.width, GamePanel.height);
        Vector2D.setWorldVar(map.x, map.y);
        states = new GameState[5];
//        states[START] = new PlayState(this);
    }

    public void pop(int state) {
        states[state] = null;
    }

    public void add(int state) {
        if (state == START) {
//            states[START] = new PlayState(this);
        } else if (state == MENU) {
            states[MENU] = new MenuState(this);
        } else if (state == PAUSE) {
            states[PAUSE] = new PauseState(this);
        } else if (state == END) {
            states[END] = new EndState(this);
        }
    }

    public void popAndAdd(int state) {
        pop(state);
        add(state);
    }

    public void update(double time) {
//        Vector2D.setWorldVar(map.x, map.y);
        for (GameState state : states) {
            if (state != null) {
                state.update(time);
            }
        }
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        for (GameState state : states) {
            if (state != null) {
                state.input(mouse, key);
            }
        }
    }

    public void render(Graphics g) {
        for (GameState state : states) {
            state.render(g);
        }

    }
}
