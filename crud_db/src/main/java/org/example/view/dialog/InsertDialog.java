package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDialog extends JDialog {
    private JPanel jPanel;
    private JLabel labelName, labelNum;
    private JTextField inputName, inputNum;
    private JButton jButton;

    public InsertDialog(){

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        labelName = new JLabel("Name : ");
        labelNum = new JLabel("Num :");
        inputName = new JTextField(20);
        inputNum = new JTextField(20);
        jButton = new JButton("OK");

        jPanel.add(labelName);
        jPanel.add(inputName);
        jPanel.add(labelNum);
        jPanel.add(inputNum);
        jPanel.add(jButton);

        this.setSize(300,150);

        this.add(jPanel);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact();
                contact.setName(inputName.getText());
                contact.setNumber(inputNum.getText());
                ContactDao contactDao = new ContactDao();
                int count = contactDao.addContact(contact);

                if(count > 0){
                    JOptionPane.showConfirmDialog(null, "Operation succeed");

                    inputName.setText("");
                    inputNum.setText("");
                } else {
                    JOptionPane.showConfirmDialog(null, "Operation Failed");
                }
                dispose();
            }
        });

    }

}
