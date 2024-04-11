package org.example;

import org.example.view.PersonFormUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PersonFormUI personFormUI = new PersonFormUI();
            }
        });

    }
}