package org.example.view.dialog;

import org.example.controller.DepartmentController;

import javax.swing.*;
import java.awt.*;

public class AddDepartmentDialog extends JDialog {

    private JPanel btnPanel;
    private JButton addBtn, cancelBtn;
    private JLabel nameLabel;
    private JTextField nameField;
    private DepartmentController departmentController;


    public AddDepartmentDialog() {

        departmentController = new DepartmentController();

        getContentPane().setLayout(new BorderLayout());

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(20);

        nameLabel.setBounds(10, 20, 80, 20);
        nameField.setBounds(10, 60, 80, 20);

        add(nameLabel);
        add(nameField);

        btnPanel = new JPanel();
        addBtn = new JButton("Add");
        cancelBtn = new JButton("Cancel");
        btnPanel.add(addBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);

    }

}
