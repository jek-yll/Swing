package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class BoxLayoutDemo {

    private JPanel panel;
    private JPanel messagePanel;

    public BoxLayoutDemo() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Ajouter message");
        addButton.setBackground(Color.MAGENTA);
        addButton.addActionListener(e -> addMessage("Un nouveau message"));

        JButton removeLastButton = new JButton("Supprimer le dernier message");
        removeLastButton.setBackground(Color.GREEN);
        removeLastButton.addActionListener( e -> removeLastMessage());

        JButton clearButton = new JButton("Effacer tous les messages");
        clearButton.setBackground(Color.blue);
        clearButton.addActionListener(e -> clearMessages());

        panel.add(addButton);
        panel.add(removeLastButton);
        panel.add(clearButton);

        panel.add(new JScrollPane(messagePanel));
    }

    private void addMessage(String message){
        messagePanel.add(new JLabel(message));
        updateUI();
    }

    private void removeLastMessage(){
        int componentCount = messagePanel.getComponentCount();
        if (componentCount > 0){
            messagePanel.remove(componentCount-1);
        }
        updateUI();
    }

    private void clearMessages(){
        messagePanel.removeAll();
        updateUI();
    }

    private void updateUI(){
        messagePanel.revalidate();
        messagePanel.repaint();
    }




}
