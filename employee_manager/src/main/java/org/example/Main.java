package org.example;

import org.example.view.EmployeeUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame appFrame = new JFrame("Employee Manager");
        appFrame.setSize(1000, 750);
        appFrame.setLocationRelativeTo(null);

        appFrame.add(new EmployeeUI().getContentPanel());

        appFrame.setVisible(true);
    }
}