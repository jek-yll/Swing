package org.example;

import org.example.layaout.FormulaireLayout;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        JFrame jFrame = new JFrame("Formulaire exercice");
        jFrame.setSize(1200,500);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new FormulaireLayout().getMainPanel());

        jFrame.setVisible(true);

    }
}