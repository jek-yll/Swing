package org.example.view.dialog;

import lombok.Data;
import org.example.controller.DepartmentController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class AddDepartmentDialog extends JDialog {

    private JPanel formPanel;
    private JButton addBtn, cancelBtn;
    private JLabel nameLabel;
    private JTextField nameField;
    private DepartmentController departmentController;

    public AddDepartmentDialog() {

        departmentController = new DepartmentController();

        setSize(230, 150);
        formPanel = new JPanel();
        formPanel.setLayout(null);
        //getContentPane().setLayout(new BorderLayout());

        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(20);

        nameLabel.setBounds(10, 20, 80, 20);
        nameField.setBounds(90, 20, 100, 20);

        formPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        addBtn = new JButton("Add");
        addBtn.setBounds(10, 50, 80, 20);
        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(110, 50, 80, 20);
        formPanel.add(addBtn);
        formPanel.add(cancelBtn);

        getContentPane().add(formPanel);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (departmentController.addDepartment(name)) {
                    JOptionPane.showMessageDialog(AddDepartmentDialog.this, "Department added successfully.");
                } else {
                    JOptionPane.showMessageDialog(AddDepartmentDialog.this, "Department already exists.");
                }
                dispose();
            }
        });
    }

}
