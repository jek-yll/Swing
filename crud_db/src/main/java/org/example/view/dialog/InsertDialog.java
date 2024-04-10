package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDialog extends JDialog {
    private JPanel jPanel, contentPanel, okPanel;
    private JLabel labelName, labelNum;
    private JTextField inputName, inputNum;
    private JButton jButton;

    public InsertDialog(){

        setSize(350, 300);
        jPanel = new JPanel();
        getContentPane().setLayout(new BorderLayout());
        jPanel.setLayout(null);
        okPanel = new JPanel();
        okPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        labelName = new JLabel("Name : ");
        labelNum = new JLabel("Num :");
        inputName = new JTextField();
        inputNum = new JTextField();
        jButton = new JButton("OK");

        labelName.setBounds(10, 20, 50, 20);
        inputName.setBounds(80, 20, 80, 20);
        labelNum.setBounds(10, 50, 50, 20 );
        inputNum.setBounds(80, 50, 80, 20);

        jPanel.add(labelName);
        jPanel.add(inputName);
        jPanel.add(labelNum);
        jPanel.add(inputNum);
        okPanel.add(jButton);
        getContentPane().add(jPanel, BorderLayout.NORTH);
        getContentPane().add(okPanel, BorderLayout.SOUTH);

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
