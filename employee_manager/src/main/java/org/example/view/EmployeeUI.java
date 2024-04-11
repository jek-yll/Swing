package org.example.view;

import lombok.Data;
import org.example.utils.EmployeeTableModel;
import org.example.view.dialog.AddEmployeeDialog;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



@Data
public class EmployeeUI extends JFrame{

    private JPanel contentPanel, btnPanel;
    private JTable table;
    private JButton addBtn, updateBtn, deleteBtn, departmentBtn;
    private TableModel employeeTableModel;
    private DepartmentUI departmentUI;

    public EmployeeUI(){

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        employeeTableModel = new EmployeeTableModel();
        table = new JTable(employeeTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        addBtn = new JButton("Add");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        departmentBtn = new JButton("Department");

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
                AddEmployeeDialog dialog = new AddEmployeeDialog(EmployeeUI.this.table);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);
                dialog.setName("Add employee");
                dialog.setVisible(true);
            }
        });

        departmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DepartmentUI departmentUI1 = new DepartmentUI();
                departmentUI1.setLocationRelativeTo(null);
                setVisible(false);
                departmentUI1.setVisible(true);
                departmentUI1.getContentPane();

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setSize(1000, 750);
                frame.setLocationRelativeTo(null);
                frame.setTitle("Employee Manager");
                frame.add(new EmployeeUI().getContentPanel());
                frame.setVisible(true);
            }
        });
    }
}
