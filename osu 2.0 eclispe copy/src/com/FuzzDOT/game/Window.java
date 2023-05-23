package com.FuzzDOT.game;
import javax.swing.*;
import javax.swing.JFrame;
public class Window extends JFrame {
    public Window(){
        setTitle("osu 2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1200, 720));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
