package org.example.view;

import lombok.Data;
import org.example.utils.EmployeeTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

@Data
public class EmployeeUI {
    private JPanel contentPanel, btnPanel;
    private JTable table;
    private JButton addBtn, updateBtn, deletBtn, departmentBtn;
    private EmployeeTableModel employeeTableModel;


    public EmployeeUI(){

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        table = new JTable((TableModel) employeeTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        addBtn = new JButton("Ajouter");
        updateBtn = new JButton("Modifier");
        deletBtn = new JButton("Supprimer");
        departmentBtn = new JButton("Departement");

        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deletBtn);
        btnPanel.add(departmentBtn);

        contentPanel.add(btnPanel, BorderLayout.SOUTH);


    }


}
