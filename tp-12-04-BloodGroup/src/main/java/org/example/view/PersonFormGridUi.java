package org.example.view;

import com.toedter.calendar.JDateChooser;
import org.example.controller.PersonController;
import org.example.model.Qualification;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;

public class PersonFormGridUi {

    private PersonController personController;
    private JFrame frame;
    private JPanel formPanel, btnPanel, tablePanel, mainPanel;
    private JTextField idInput, nameInput, ageInput, contactInput, imagePathInput, searchInput, addressInput, bloodGroupInput;
    private JButton newBtn, saveBtn, updateBtn, deleteBtn, clearBtn, printBtn, uploadImageBtn;
    private JRadioButton maleRadio, femaleRadio;
    private JComboBox<String> qualificationComboBox;
    private JDateChooser dateChooser;
    private JTable dataTable;

    public PersonFormGridUi(){
        personController = new PersonController();
        initUI();
    }

    private void initUI() {

        frame = new JFrame("Person Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.setLayout(new BorderLayout());

        formPanel = new JPanel();
        tablePanel = new JPanel();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        /*
        FORMULAIRE
        */

        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        new EmptyBorder(10, 10, 10, 10),
                        new LineBorder(Color.BLACK, 1)
                )
        );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        // ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        idInput = new JTextField(10);
        formPanel.add(idInput, gbc);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        nameInput = new JTextField(10);
        formPanel.add(nameInput, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        formPanel.add(genderPanel, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        ageInput = new JTextField(10);
        formPanel.add(ageInput, gbc);

        // Blood Group
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Blood Group:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        bloodGroupInput = new JTextField(10);
        formPanel.add(bloodGroupInput, gbc);

        // Contact
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Contact:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        contactInput = new JTextField(10);
        formPanel.add(contactInput, gbc);

        // Qualification
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(new JLabel("Qualification:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        qualificationComboBox = new JComboBox<>();
        for (Qualification qualification : Qualification.values()) {
            qualificationComboBox.addItem(qualification.toString());
        }
        formPanel.add(qualificationComboBox, gbc);

        // Start Date
        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(new JLabel("Start Date:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        dateChooser = new JDateChooser();
        formPanel.add(dateChooser, gbc);

        // Address
        gbc.gridx = 2;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        addressInput = new JTextField(10);
        formPanel.add(addressInput, gbc);

        // Image Path
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridheight = 1;
        formPanel.add(new JLabel("Image Path:"), gbc);
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        uploadImageBtn = new JButton("Upload Image");
        formPanel.add(uploadImageBtn, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 3;
        gbc.gridy = 7;
        imagePathInput = new JTextField(10);
        formPanel.add(imagePathInput, gbc);

        JLabel photoLabel = new JLabel("img");
        photoLabel.setPreferredSize(new Dimension(120, 150));
        photoLabel.setBorder(new LineBorder(Color.BLACK));
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 9;
        formPanel.add(photoLabel, gbc);

        frame.add(formPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

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

//        mainPanel.add(formPanel);
//        mainPanel.add(btnPanel);
//        mainPanel.add(scrollPane);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);


        frame.add(mainPanel);
        frame.pack();

        frame.setVisible(true);
    }

}
