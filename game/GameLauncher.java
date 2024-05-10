package OOP.game;

import javax.swing.*;

public class GameLauncher {
    public static void main(String[] args) throws InterruptedException {
        JFrame window = new JFrame();

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.setTitle("Dungeon Maze");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startThread();
    }
}
