package org.example.component;

import javax.swing.*;
import java.awt.*;

public class JListdemo extends JFrame{


    public JListdemo(){
        String[] listItems = {"item1", "item2", "item3", "item4"};
        JList<String> list = new JList<>(listItems);
        JLabel label = new JLabel("Aucun élément selectionné");

        list.addListSelectionListener( e -> {
            String selectedItem  = list.getSelectedValue();
            label.setText("Exemple selectionné : " + selectedItem);
        });

        this.getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);
        this.getContentPane().add(label, BorderLayout.NORTH);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JListdemo example = new JListdemo();
            example.setVisible(true);
        });
    }
}
