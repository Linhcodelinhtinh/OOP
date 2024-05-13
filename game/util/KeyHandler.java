package OOP.game.util;

import OOP.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener {
    public static List<KeyListen> listeners = new ArrayList<KeyListen>();
    public static class KeyListen { // so it should be static
        public int presses, absorbs;
        public boolean down, clicked;
        public KeyListen() {
            listeners.add(this);
        }
        public void toggle(boolean pressed){
            if(pressed != down){  //not really sure if these lines should be presses or pressed
                down = pressed ;  //and clicked& down should be boolean or int, but somehow it works well so ... yeah =)))
            }
            if(pressed){
                presses++;
            }
        }
    }
    public KeyListen up = new KeyListen();
    public KeyListen down = new KeyListen() {};
    public KeyListen left = new KeyListen() {};
    public KeyListen right = new KeyListen() {};
    public KeyListen enter = new KeyListen() {};
    public KeyListen exit = new KeyListen() {};
//    public KeyListen menu = new KeyListen() {};
//    public KeyListen attack = new KeyListen() {};

    public KeyHandler(GamePanel gamePanel) {
        gamePanel.addKeyListener(this);
    }

    public void toggle(KeyEvent e, boolean pressed){
        if(e.getKeyCode() == KeyEvent.VK_W){
            up.toggle(pressed);
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            down.toggle(pressed);
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            left.toggle(pressed);
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            right.toggle(pressed);
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enter.toggle(pressed);
        }
//        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
//            exit.toggle(pressed);
//        }
//        if(e.getKeyCode() == KeyEvent.VK_SPACE){
//            attack.toggle(pressed);
//        }
//        if(e.getKeyCode() == KeyEvent.VK_M){
//            menu.toggle(pressed);
//        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
}