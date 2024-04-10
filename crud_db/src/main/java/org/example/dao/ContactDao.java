package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    Connection con;
    private PreparedStatement ps;

    public int addContact(Contact contact)  {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("INSERT INTO `contact`(`name`, `number`) values(?,?) ");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteContact(int id) {
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("DELETE FROM `contact` WHERE `id` = ?");
            ps.setInt(1, id);

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int updateContact (Contact contactUpdated){
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("UPDATE `contact` SET `name` = ?, `number` = ? WHERE `id` = ?");
            ps.setString(1, contactUpdated.getName());
            ps.setString(2, contactUpdated.getNumber());
            ps.setInt(3, contactUpdated.getId());

            return ps.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Contact> getContacts (){
        List<Contact> contacts = new ArrayList<>();
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM `contact`");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("name"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    public Contact getContactById(int id){
        con = ConnectionUtil.getConnection();

        try {
            ps = con.prepareStatement("SELECT * FROM `contact` WHERE `id` = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("number"));
                    return contact;
            } else {
                return null;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



}
