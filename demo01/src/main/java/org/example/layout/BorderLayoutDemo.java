package org.example.layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JPanel {
    private JButton jButton0;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;

    public BorderLayoutDemo(){

        setLayout(new BorderLayout());
        jButton0 = new JButton("NORTH");
        jButton1 = new JButton("SOUTH");
        jButton2 = new JButton("EAST");
        jButton3 = new JButton("WEST");
        jButton4 = new JButton("CENTER");

        jButton0.setForeground(Color.blue);
        jButton1.setForeground(Color.green);
        jButton2.setForeground(Color.pink);
        jButton3.setForeground(Color.orange);
        jButton4.setForeground(Color.red);

        add(jButton0, BorderLayout.NORTH);
        add(jButton1, BorderLayout.SOUTH);
        add(jButton2, BorderLayout.EAST);
        add(jButton3, BorderLayout.WEST);
        add(jButton4, BorderLayout.CENTER);


    }

}
