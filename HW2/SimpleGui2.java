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
        button1.setBounds(800,400,180,90);
        button2.setBounds(480,360,180,90);
        button2.addActionListener(this);
        button1.addActionListener(this);

        JFrame frame = new JFrame("My First Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(button2.isSelected())
            button2.setText("I've been chosen!");
        button1.setText("I've been clicked!");
    }

    public static void main(String[] args) {
        SimpleGui2 gui = new SimpleGui2();
        gui.go();
    }
}
