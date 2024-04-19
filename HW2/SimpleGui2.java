package OOP.HW2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui2 implements ActionListener {
    private JButton button1;
    private JButton button2;

    public void go() {
        button2 = new JButton("choose me\n");
        button1 = new JButton("click me\n");
        button1.setBounds(100,100,180,90);
//        button2.addActionListener();
        button1.addActionListener(this);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, button1);
        frame.getContentPane().add(BorderLayout.NORTH, button2);
        frame.setSize(1080,720);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        button1.setText("I've been clicked!");
        button2.setText("I've been chosen!");
    }

    public static void main(String[] args) {
        SimpleGui2 gui = new SimpleGui2();
        gui.go();
    }
}
