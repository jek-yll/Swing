package org.example.layaout;

import lombok.Data;
import org.example.model.Personne;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

@Data
public class FormulaireLayout extends JFrame{

    private JPanel mainPanel;
    private JPanel namePanel;
    private JPanel emailPanel;
    private JPanel genderPanel;
    private JButton validateButton;
    private JButton detailButton;
    private JTable dataTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private Personne personne;
    private JDialog dialog;
    private JPanel detailsPanel;

    public FormulaireLayout(){

        mainPanel = new JPanel();
        mainPanel.setName("Formulaire d'ajout'");

        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelName = new JLabel("Name :");
        namePanel.add(labelName);
        JTextField inputName = new JTextField(20);
        namePanel.add(inputName);

        emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelEmail = new JLabel("Email :");
        emailPanel.add(labelEmail);
        JTextField inputEmail = new JTextField(20);
        emailPanel.add(inputEmail);

        genderPanel =  new JPanel();
        genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelGender = new JLabel("Gender :");
        JRadioButton radioButtonH = new JRadioButton("Homme");
        JRadioButton radioButtonF = new JRadioButton("Femme");
        genderPanel.add(labelGender);
        genderPanel.add(radioButtonH);
        genderPanel.add(radioButtonF);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(radioButtonH);
        genderButtonGroup.add(radioButtonF);

        validateButton = new JButton("Submit");

        validateButton.addActionListener(e -> {
            personne = new Personne();

            personne.setName(inputName.getText());
            personne.setEmail(inputEmail.getText());

            if (radioButtonH.isSelected()){
                personne.setGender("Homme");
            } else if (radioButtonF.isSelected()){
                personne.setGender("Femme");
            }
            //personnes.add(personne);
            Vector<String> rowData = new Vector<>();
            rowData.add(personne.getName());
            rowData.add(personne.getEmail());
            rowData.add(personne.getGender());
            tableModel.addRow(rowData);

            System.out.println(personne);
        });

        detailButton = new JButton("details");
        detailButton.addActionListener(e -> {

            dialog = new JDialog();
            


        });

        tableModel = new DefaultTableModel();
        tableModel.addColumn("NOM");
        tableModel.addColumn("EMAIL");
        tableModel.addColumn("GENRE");

        dataTable = new JTable(tableModel);
        dataTable.setBounds(30,40,200,200);
        scrollPane = new JScrollPane(dataTable);

        mainPanel.add(namePanel);
        mainPanel.add(emailPanel);
        mainPanel.add(genderPanel);
        mainPanel.add(validateButton);
        mainPanel.add(scrollPane);
        mainPanel.add(detailButton);

        this.getContentPane().add(mainPanel);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            FormulaireLayout form = new FormulaireLayout();
            form.setVisible(true);

        });
    }

}
