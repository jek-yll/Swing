package org.example.view;

import org.example.controller.PersonController;

import javax.swing.*;
import java.awt.*;

public class PersonFormUI{

    private PersonController personController;
    private JFrame frame;
    private JPanel formPanel, btnPanel, tablePanel, mainPanel;
    private JTextField idInput, nameInput, ageInput, contactInput, imagePathInput, searchInput, addressInput;
    private JButton newBtn, saveBtn, updateBtn, deleteBtn, clearBtn, printBtn;


    public PersonFormUI(){
        personController = new PersonController();
        initUI();
    }

    private void initUI() {

        frame = new JFrame("Person Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        formPanel = new JPanel();
        btnPanel = new JPanel();
        tablePanel = new JPanel();


        formPanel.setLayout(null);
        formPanel.setSize(1200, 500);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(20, 20, 100, 20);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20, 50, 100, 20);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(20, 80, 100, 20);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(20, 110, 100, 20);

        JLabel bloodLabel = new JLabel("Blood Group");
        bloodLabel.setBounds(20, 140, 100, 20);

        JLabel contactLabel = new JLabel("Contact");
        contactLabel.setBounds(20, 170, 100, 20);

        JLabel qualificationLabel = new JLabel("Qualification");
        qualificationLabel.setBounds(20, 200, 100, 20);

        JLabel startDateLabel = new JLabel("Start Date");
        startDateLabel.setBounds(20, 230, 100, 20);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(500, 20, 100, 20);

        JLabel imagePathLabel = new JLabel("Image Path");
        imagePathLabel.setBounds(500, 230, 100, 20);

        idInput = new JTextField();
        idInput.setBounds(200, 20, 100, 20);
        nameInput = new JTextField();
        nameInput.setBounds(200, 50, 100, 20);
        ageInput = new JTextField();
        ageInput.setBounds(200, 80, 100, 20);
        contactInput = new JTextField();
        contactInput.setBounds(200, 110, 100, 20);
        imagePathInput = new JTextField();
        imagePathInput.setBounds(200, 140, 100, 20);
        searchInput = new JTextField();
        searchInput.setBounds(200, 170, 100, 20);
        addressInput = new JTextField();
        addressInput.setBounds(200, 200, 100, 20);


        formPanel.add(idLabel);
        formPanel.add(nameLabel);
        formPanel.add(genderLabel);
        formPanel.add(ageLabel);
        formPanel.add(bloodLabel);
        formPanel.add(contactLabel);
        formPanel.add(qualificationLabel);
        formPanel.add(startDateLabel);
        formPanel.add(addressLabel);
        formPanel.add(imagePathLabel);
        formPanel.add(idInput);
        formPanel.add(nameInput);
        formPanel.add(ageInput);
        formPanel.add(contactInput);
        formPanel.add(imagePathInput);
        formPanel.add(searchInput);
        formPanel.add(addressInput);


        frame.add(formPanel);
        frame.setVisible(true);

    }

}
