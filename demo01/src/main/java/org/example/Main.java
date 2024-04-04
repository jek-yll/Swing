package org.example;

import org.example.layout.BorderLayoutDemo;
import org.example.layout.FlowLayoutDemo;
import org.example.layout.GridBagLayoutDemo;
import org.example.layout.GridLayoutDemo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Demo Layout");
        jFrame.setSize(1200, 500);
        jFrame.setLocationRelativeTo(null);
        //jFrame.setResizable(false);
        //jFrame.add(new BorderLayoutDemo());
        //jFrame.pack();
        //jFrame.add(new FlowLayoutDemo().getJPanel());
        //jFrame.add(new GridLayoutDemo().getJPanel());
        jFrame.add(new GridBagLayoutDemo().getJPanel());
        jFrame.setVisible(true);
    }

}