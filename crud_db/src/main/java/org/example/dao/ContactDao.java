package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDao {

    Connection con;
    private PreparedStatement ps;

    public int addContact(Contact contact)  {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("INSERT INTO 'contact'('name', 'number') values(?,?) ");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
