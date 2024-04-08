package org.example.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculate extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, equButton, clrButton, dotButton;
    private JPanel panel;

    // Variables
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculate() {
        setTitle("Calculatrice");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 50));
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);


        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        dotButton = new JButton(".");
        functionButtons = new JButton[]{addButton, subButton, mulButton, divButton, equButton, clrButton, dotButton};
        for (JButton button : functionButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
        }


        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.add(textField);
        panel.add(clrButton);
        panel.add(divButton);
        panel.add(mulButton);
        panel.add(subButton);
        panel.add(addButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[0]);
        panel.add(dotButton);
        panel.add(equButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dotButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        textField.setText("Erreur : division par zéro !");
                        return;
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
    }
}