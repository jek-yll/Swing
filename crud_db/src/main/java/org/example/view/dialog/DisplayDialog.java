package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class DisplayDialog extends JDialog {

    private JPanel contentPanel;
    private DefaultTableModel tableModel;
    private JTable dataTable;
    private ContactDao contactDao;

    public DisplayDialog(){
        contactDao = new ContactDao();
        Object[][] data = getContacts();
        String columns[] = {"ID", "NAME", "NUMBER"};

        tableModel = new DefaultTableModel(data, columns);
        dataTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(dataTable);

        getContentPane().add(scrollPane);
        setSize(500, 500);
    }

    private Object[][] getContacts(){

        Contact[] contacts = contactDao.getContacts().toArray(new Contact[0]);
        Object[][] data = new Object[contacts.length][3];

        for (int i = 0; i < contacts.length; i++) {
            data[i][0] = contacts[i].getId();
            data[i][1] = contacts[i].getName();
            data[i][2] = contacts[i].getNumber();
        }
        return data;
    }


}
