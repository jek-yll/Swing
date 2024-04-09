package org.example;

import org.example.layout.TaquinLayout;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("TAQUIN");
        jFrame.setSize(600,600);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new TaquinLayout().getGridPanel());
        jFrame.setVisible(true);
    }
}