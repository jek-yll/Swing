package org.example;

import org.example.components.Calculate;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        JFrame jFrame = new JFrame("Calculatrice 3000");
        jFrame.setSize(750, 800);
        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);

        new Calculate();

    }
}