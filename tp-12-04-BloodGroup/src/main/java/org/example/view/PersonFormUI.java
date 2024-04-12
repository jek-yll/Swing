package org.example.view;

import com.toedter.calendar.JDateChooser;
import org.example.controller.PersonController;
import org.example.model.Qualification;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class PersonFormUI{

    private PersonController personController;
    private JFrame frame;
    private JPanel formPanel, btnPanel, tablePanel, mainPanel;
    private JTextField idInput, nameInput, ageInput, contactInput, imagePathInput, searchInput, addressInput, bloodGroupInput;
    private JButton newBtn, saveBtn, updateBtn, deleteBtn, clearBtn, printBtn, uploadImageBtn;
    private JRadioButton maleRadio, femaleRadio;
    private JComboBox<String> qualificationComboBox;
    private JDateChooser dateChooser;
    private JTable dataTable;

    public PersonFormUI(){
        personController = new PersonController();
        initUI();
    }

    private void initUI() {

        frame = new JFrame("Person Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);
        //frame.setLayout(new BorderLayout());

        formPanel = new JPanel();
        tablePanel = new JPanel();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        /*
        FORMULAIRE
        */

        formPanel.setLayout(null);
        formPanel.setSize(1200, 500);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(20, 20, 100, 20);
        idInput = new JTextField();
        idInput.setBounds(130, 20, 150, 20);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20, 55, 100, 20);
        nameInput = new JTextField();
        nameInput.setBounds(130, 55, 150, 20);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(20, 85, 100, 20);
        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(130, 85, 100, 20);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(240, 85, 150, 20);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(20, 115, 100, 20);
        ageInput = new JTextField();
        ageInput.setBounds(130, 115, 150, 20);

        JLabel bloodLabel = new JLabel("Blood Group");
        bloodLabel.setBounds(20, 145, 100, 20);
        bloodGroupInput = new JTextField();
        bloodGroupInput.setBounds(130, 145, 150, 20);

        JLabel contactLabel = new JLabel("Contact");
        contactLabel.setBounds(20, 175, 100, 20);
        contactInput = new JTextField();
        contactInput.setBounds(130, 175, 150, 20);

        JLabel qualificationLabel = new JLabel("Qualification");
        qualificationLabel.setBounds(20, 205, 100, 20);
        qualificationComboBox = new JComboBox<String>();
        for (Qualification qualification : Qualification.values()) {
            qualificationComboBox.addItem(qualification.toString());
        }
        qualificationComboBox.setBounds(130, 205, 150, 20);

        JLabel startDateLabel = new JLabel("Start Date");
        startDateLabel.setBounds(20, 235, 100, 20);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(130, 235, 150, 20);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(500, 20, 100, 20);
        addressInput = new JTextField();
        addressInput.setBounds(610, 20, 150, 150);

        JLabel imagePathLabel = new JLabel("Image Path");
        imagePathLabel.setBounds(500, 235, 100, 20);
        uploadImageBtn = new JButton("Upload Image");
        uploadImageBtn.setBounds(610, 205, 150, 20);
        imagePathInput = new JTextField();
        imagePathInput.setBounds(610, 235, 150, 20);

        for(JLabel jLabel: Arrays.asList(idLabel, nameLabel, genderLabel, ageLabel, bloodLabel, contactLabel, qualificationLabel, startDateLabel, addressLabel, imagePathLabel)){
            formPanel.add(jLabel);
        }
        for (JTextField jTextField : Arrays.asList(idInput, nameInput, ageInput, contactInput, imagePathInput, addressInput)) {
            formPanel.add(jTextField);
        }
        formPanel.add(maleRadio);
        formPanel.add(femaleRadio);
        formPanel.add(qualificationComboBox);
        formPanel.add(bloodGroupInput);
        formPanel.add(uploadImageBtn);
        formPanel.add(dateChooser);

        /*
        BOUTTONS
        */
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10, 10 ));
        JLabel searchLabel = new JLabel("Search");
        searchInput = new JTextField(20);
        newBtn = new JButton("New");
        saveBtn = new JButton("Save");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        printBtn = new JButton("Print");

        btnPanel.add(searchLabel);
        btnPanel.add(searchInput);
        for (JButton jButton : Arrays.asList(newBtn, saveBtn, updateBtn, deleteBtn, clearBtn)) {
            btnPanel.add(jButton);
        }

        /*
        TABLE
        */
        String column[] ={"ID", "NAME", "GENDER", "AGE", "BLOODGROUP", "CONTACT", "QUALIFICATION", "DOJ", "ADDRESS", "IMG"};
        String rows[][] = new String[1][column.length];
        dataTable = new JTable(rows, column);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        /*
        MAIN
        */

        mainPanel.add(formPanel);
        mainPanel.add(btnPanel);
        mainPanel.add(scrollPane);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

}
