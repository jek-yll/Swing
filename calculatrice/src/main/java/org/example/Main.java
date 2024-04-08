package org.example;

import org.example.components.Calculate;
import org.example.components.ScreenLayout;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        JFrame jFrame = new JFrame("Calculatrice 3000");
        jFrame.setSize(750, 800);
        jFrame.setLocationRelativeTo(null);
//
        jFrame.setVisible(true);
        jFrame.add(new ScreenLayout().getJPanel());


        // new Calculate();

    }
}