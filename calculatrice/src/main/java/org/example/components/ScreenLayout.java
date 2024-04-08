package org.example.components;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class ScreenLayout {

    private JPanel jPanel;

    public  ScreenLayout(){

        jPanel = new JPanel(new FlowLayout());

        JTextField screen = new JTextField(40);
        jPanel.add(screen);

    }

}
