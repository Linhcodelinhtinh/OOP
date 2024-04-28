package OOP.game;


import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class Window extends JFrame {
    Image background;
    Image character;
    Image enemy;

    Window() {
        setTitle("Dungeon Maze");
        setBackground(Color.DARK_GRAY);
        setContentPane(new GamePanel(1920, 1080));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}


