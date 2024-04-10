package org.example.view;

import org.example.view.dialog.DeleteDialog;
import org.example.view.dialog.DisplayDialog;
import org.example.view.dialog.InsertDialog;
import org.example.view.dialog.UpdateDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaineFrame extends JFrame {

    private JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MaineFrame maineFrame = new MaineFrame();
                    maineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    maineFrame.setSize(420, 230);
                    maineFrame.setTitle("Main Frame");
                    maineFrame.setLocationRelativeTo(null);
                    maineFrame.setVisible(true);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public MaineFrame(){
        panel =  new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(panel);
        panel.setLayout(null);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(36, 23, 100, 25);
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertDialog dialog = new InsertDialog();
                // dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
                dialog.setLocationRelativeTo(panel);
                dialog.setVisible(true);
            }
        });


        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(136, 23, 100, 25);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateDialog updateDialog = new UpdateDialog();
                updateDialog.setLocationRelativeTo(panel);
                updateDialog.setVisible(true);
            }
        });


        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(236, 23, 100, 25);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog dialog = new DeleteDialog();
                dialog.setLocationRelativeTo(panel);
                dialog.setVisible(true);
            }
        });

        JButton btnDisplay = new JButton("Display");
        btnDisplay.setBounds(136, 50, 100, 25);
        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayDialog dialog = new DisplayDialog();
                dialog.setLocationRelativeTo(panel);
                dialog.setVisible(true);
            }
        });

        panel.add(btnInsert);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnDisplay);

    }

}
