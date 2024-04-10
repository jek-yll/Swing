package org.example.view.dialog;

import javax.swing.*;

public class AddEmployeeDialog extends JDialog {

    private JPanel formPanel;
    private JTextField firstnameInput, lastnameInput;
    private JRadioButton managerRadioBtn, employeeRadioBtn, rhRadioBtn;
    private JComboBox<String> departmentComboBox;

    public AddEmployeeDialog(){

        formPanel = new JPanel();
        formPanel.setLayout(null);

        JLabel firstnameLabel = new JLabel();
        firstnameLabel.setBounds(10, 20, 20, 10);
        JLabel lastnameLabel = new JLabel();
        lastnameLabel.setBounds(10, 45, 20, 10);
        JLabel roleLabel = new JLabel();
        roleLabel.setBounds(10, 70, 20, 10);
        JLabel departmentLabel = new JLabel();
        departmentLabel.setBounds(10, 95, 20, 10);

        firstnameInput = new JTextField();
        firstnameInput.setBounds(40, 20, 30, 10);

        lastnameInput = new JTextField();
        firstnameInput.setBounds(40, 45, 30, 10);


    }


}
