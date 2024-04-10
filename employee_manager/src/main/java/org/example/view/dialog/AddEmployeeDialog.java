package org.example.view.dialog;

import org.example.controller.DepartmentController;
import org.example.controller.EmployeeController;
import org.example.model.Department;
import org.example.model.RoleEmp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeDialog extends JDialog {

    private JPanel formPanel;
    private JTextField firstnameInput, lastnameInput;
    private JRadioButton managerRadioBtn, employeeRadioBtn, rhRadioBtn;
    private JComboBox<String> departmentComboBox;
    private JButton addBtn, cancelBtn;
    private DepartmentController departmentController;
    private EmployeeController employeeController;

    public AddEmployeeDialog(){

        departmentController = new DepartmentController();
        employeeController = new EmployeeController();

        setSize(580, 350);
        formPanel = new JPanel();
        formPanel.setLayout(null);

        JLabel firstnameLabel = new JLabel("First Name :");
        firstnameLabel.setBounds(10, 20, 80, 20);
        JLabel lastnameLabel = new JLabel("Last Name :");
        lastnameLabel.setBounds(10, 50, 80, 20);
        JLabel roleLabel = new JLabel("Role :");
        roleLabel.setBounds(10, 80, 80, 20);
        JLabel departmentLabel = new JLabel("Department :");
        departmentLabel.setBounds(10, 110, 80, 20);

        firstnameInput = new JTextField();
        firstnameInput.setBounds(100, 20, 120, 20);

        lastnameInput = new JTextField();
        lastnameInput.setBounds(100, 50, 120, 20);

        managerRadioBtn = new JRadioButton("MANAGER");
        managerRadioBtn.setBounds(100, 80, 100, 20);
        employeeRadioBtn = new JRadioButton("EMPLOYEE");
        employeeRadioBtn.setBounds(200, 80, 100, 20);
        rhRadioBtn = new JRadioButton("RH");
        rhRadioBtn.setBounds(300, 80, 100, 20);

        ButtonGroup roleBtnGroup = new ButtonGroup();
        roleBtnGroup.add(managerRadioBtn);
        roleBtnGroup.add(employeeRadioBtn);
        roleBtnGroup.add(rhRadioBtn);

        String[] departmentNames = departmentController.getDepartments()
                .stream()
                .map(Department::getName)
                .toArray(String[]::new);

        departmentComboBox = new JComboBox<String>(departmentNames);
        departmentComboBox.setBounds(100, 110, 150, 20);

        addBtn = new JButton("Add");
        addBtn.setBounds(250, 180, 70, 20);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = firstnameInput.getText();
                String lastname = lastnameInput.getText();

                String selectedRole = "";
                if (managerRadioBtn.isSelected()) {
                    selectedRole = managerRadioBtn.getText();
                } else if (employeeRadioBtn.isSelected()) {
                    selectedRole = employeeRadioBtn.getText();
                } else if (rhRadioBtn.isSelected()) {
                    selectedRole = rhRadioBtn.getText();
                }

                RoleEmp role = RoleEmp.valueOf(selectedRole);
                Department department = departmentController.getDepartmentByName((String) departmentComboBox.getSelectedItem());

                if (employeeController.addEmployee(firstname,lastname,role,department)){
                    JOptionPane.showConfirmDialog(null, "Employee added successfully !");
                } else {
                    JOptionPane.showConfirmDialog(null, "Failed to add employee");
                }
                dispose();
            }

        });

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(330, 180, 100, 20);

        formPanel.add(firstnameLabel);
        formPanel.add(firstnameInput);
        formPanel.add(lastnameLabel);
        formPanel.add(lastnameInput);
        formPanel.add(roleLabel);
        formPanel.add(managerRadioBtn);
        formPanel.add(employeeRadioBtn);
        formPanel.add(rhRadioBtn);
        formPanel.add(departmentLabel);
        formPanel.add(departmentComboBox);
        formPanel.add(addBtn);
        formPanel.add(cancelBtn);

        getContentPane().add(formPanel);
    }


}
