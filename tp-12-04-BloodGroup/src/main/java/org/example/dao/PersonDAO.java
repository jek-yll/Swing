package org.example.dao;

import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Qualification;
import org.example.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDAO implements IBaseDAO <Person>{

    private Connection con;

    public PersonDAO(){
        try {
            con = ConnectionUtil.getConnection();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public int add(Person person) {
        String query = "INSERT INTO person (name, gender, age, blood_group, contact_no, qualification, start_date, address, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        try {
            PreparedStatement ps = preparePerson(person, query);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {
        String query = "DELETE FROM person WHERE id = ?";
        int result = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Person person) {
        String query = "UPDATE person SET name=?, gender=?, age=?, blood_group=?, contact_no=?, qualification=?, start_date=?, address=?, image=? WHERE id = ?";
        int result = 0;
        try {
            PreparedStatement ps = preparePerson(person, query);
            ps.setInt(10, person.getId());
            result = ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        String query = "SELECT * FROM person";
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setGender(Gender.valueOf(rs.getString("gender")));
                person.setAge(rs.getInt("age"));
                person.setContactNo(rs.getString("contact_no"));
                person.setQualification(Qualification.valueOf(rs.getString("qualification")));
                person.setStartDate(rs.getDate("start_date"));
                person.setAddress(rs.getString("address"));
                person.setImage(rs.getString("image"));
                persons.add(person);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person getById(int id) {
        String query = "SELECT * FROM person WHERE id = ?";
        Person person = null;
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                Gender gender = Gender.valueOf(rs.getString("gender"));
                int age = rs.getInt("age");
                String contactNo = rs.getString("contact_no");
                Qualification qualification = Qualification.valueOf(rs.getString("qualification"));
                Date startDate = rs.getDate("start_date");
                String address = rs.getString("address");
                String image = rs.getString("image");
                person = Person.builder()
                        .name(name)
                        .gender(gender)
                        .age(age)
                        .contactNo(contactNo)
                        .qualification(qualification)
                        .startDate(startDate)
                        .address(address)
                        .image(image)
                        .build();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return person;
    }

    private PreparedStatement preparePerson(Person person, String query) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, person.getName());
        ps.setString(2, person.getGender().toString());
        ps.setInt(3, person.getAge());
        ps.setString(4, person.getBloodGroup());
        ps.setString(5, person.getContactNo());
        ps.setString(6, person.getQualification().toString());
        ps.setString(7, person.getStartDate().toString());
        ps.setString(8, person.getAddress());
        ps.setString(9, person.getImage());
        return ps;
    }
}
