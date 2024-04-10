package org.example.view.dialog;

import org.example.dao.ContactDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog extends JDialog{
    private JPanel contentPanel, okPanel, bigPanel;
    private JTextField inputId;
    private JLabel labelId;
    private JButton okBtn;
    public DeleteDialog(){

        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        okPanel = new JPanel();
        okPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        labelId = new JLabel("Id :");
        inputId = new JTextField(15);
        okBtn = new JButton("OK");

        contentPanel.add(labelId);
        contentPanel.add(inputId);
        okPanel.add(okBtn);

        this.setSize(300, 150);
        bigPanel.add(contentPanel, BorderLayout.CENTER);
        bigPanel.add(okPanel, BorderLayout.SOUTH);
        add(bigPanel);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(inputId.getText());
                ContactDao contactDao = new ContactDao();
                int count = contactDao.deleteContact(id);

                if (count > 0){
                    JOptionPane.showConfirmDialog(null, "success");
                } else {
                    JOptionPane.showConfirmDialog(null, "Error");
                }
                dispose();
            }
        });

    }

}
