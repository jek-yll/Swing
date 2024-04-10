package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDialog extends JDialog {

    private JPanel contentPanel, okPanel, bigPanel;
    private JLabel labelId, labelName, labelNum;
    private JTextField inputId, inputName, inputNum;
    private JButton searchBtn, okBtn;

    public UpdateDialog(){

        setSize(350, 300);
        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        okPanel = new JPanel();
        okPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        labelId = new JLabel("Id :");
        labelId.setBounds(10, 20, 25, 20);
        inputId = new JTextField();
        inputId.setBounds(80, 20, 40, 20);
        searchBtn = new JButton("Search");
        searchBtn.setBounds(165, 20, 120, 20);

        labelName = new JLabel("Name :");
        labelName.setBounds(10, 50, 50, 20);
        inputName = new JTextField();
        inputName.setBounds(80, 50, 80, 20);

        labelNum = new JLabel("Num :");
        labelNum.setBounds(10, 80, 50, 20 );
        inputNum = new JTextField(20);
        inputNum.setBounds(80, 80, 80, 20);

        okBtn = new JButton("OK");

        contentPanel.add(labelId);
        contentPanel.add(inputId);
        contentPanel.add(searchBtn);
        contentPanel.add(labelName);
        contentPanel.add(inputName);
        contentPanel.add(labelNum);
        contentPanel.add(inputNum);

        okPanel.add(okBtn);

        bigPanel.add(contentPanel, BorderLayout.CENTER);
        bigPanel.add(okPanel, BorderLayout.SOUTH);

        getContentPane().add(bigPanel);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactDao contactDao = new ContactDao();
                Contact contact = contactDao.getContactById(Integer.parseInt(inputId.getText()));

                inputName.setText(contact.getName());
                inputNum.setText(contact.getNumber());
                inputId.setEnabled(false);

            }
        });

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contactUpdated = new Contact();
                ContactDao contactDao = new ContactDao();
                contactUpdated.setId(Integer.parseInt(inputId.getText()));
                contactUpdated.setName(inputName.getText());
                contactUpdated.setNumber(inputNum.getText());

                int count = contactDao.updateContact(contactUpdated);

                if (count>0){
                    JOptionPane.showConfirmDialog(null, "Contact " + contactUpdated.getId() + " updated");

                } else {
                    System.out.println(contactUpdated);
                    JOptionPane.showConfirmDialog(null, "Error");
                }
                dispose();
            }
        });
    }
}
