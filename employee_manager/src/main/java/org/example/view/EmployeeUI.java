package org.example.view;

import lombok.Data;
import org.example.utils.EmployeeTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class EmployeeUI {
    private JPanel contentPanel, btnPanel;
    private JTable table;
    private JButton addBtn, updateBtn, deleteBtn, departmentBtn;
    private TableModel employeeTableModel;


    public EmployeeUI(){

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        employeeTableModel =new EmployeeTableModel();
        table = new JTable((TableModel) employeeTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");
        deleteBtn = new JButton("Supprimer");
        departmentBtn = new JButton("Departement");

        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(departmentBtn);

        contentPanel.add(btnPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });

    }



}
