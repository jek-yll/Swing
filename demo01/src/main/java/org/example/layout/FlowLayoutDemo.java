package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class FlowLayoutDemo{

    private JPanel jPanel;
    private JLabel resultLabel;
    private JComboBox<String> comboBox;


    public FlowLayoutDemo() {

        jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,20));

        JButton button = new JButton("Button 1");
        button.setBackground(Color.GREEN);
        button.addActionListener(e -> System.out.println("Button click"));
        jPanel.add(button);

        jPanel.add(new JButton("button2"));
        jPanel.add(new JButton("button3"));

        jPanel.add(new JLabel("Label"));

        JTextField input = new JTextField(20);
        jPanel.add(input);

        comboBox = new JComboBox<>(new String[]{"option1", "option2", "option3", "option4"});
        jPanel.add(comboBox);

        resultLabel = new JLabel("Resultat et Selection s'afficheront ici");
        jPanel.add(resultLabel);

        JButton validateButton = new JButton("Valider");

        validateButton.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            String inputText = input.getText();

            resultLabel.setText("Input data : " + inputText + " Selected data : " + selected);
        });

        jPanel.add(validateButton);

    }
}
