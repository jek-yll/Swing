package org.example.view;

import lombok.Data;
import org.example.controller.DepartmentController;
import org.example.model.Department;
import org.example.view.dialog.AddDepartmentDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class DepartmentUI extends JFrame{

    private JPanel contentPanel, btnPanel;
    private JList<Department> list;
    private JButton addBtn, updateBtn, deleteBtn, employeeBtn;
    private DepartmentController departmentController;
    private EmployeeUI employeeUI;

    public DepartmentUI(){


        departmentController = new DepartmentController();

        setTitle("Department Manager");
        setLocationRelativeTo(null);
        setSize(1000, 750);
        setVisible(true);


        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        Department[] departments = departmentController.getDepartments().toArray(new Department[0]);
        list = new JList<>(departments);
        JScrollPane scrollPane = new JScrollPane(list);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
        employeeBtn = new JButton("Employee");

        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(employeeBtn);

        contentPanel.add(btnPanel, BorderLayout.SOUTH);
        add(contentPanel);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new AddDepartmentDialog();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);
                dialog.setName("Add Department");
                dialog.setVisible(true);
            }
        });

        employeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


    }




}
