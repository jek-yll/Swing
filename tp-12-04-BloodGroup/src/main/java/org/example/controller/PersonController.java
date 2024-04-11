package org.example.controller;

import org.example.dao.PersonDAO;
import org.example.model.Person;

import java.util.List;

public class PersonController {

    private PersonDAO personDAO;

    public PersonController() {
        this.personDAO = new PersonDAO();
    }

    public List<Person> getAllPersons() {
        return personDAO.getAll();
    }

    public Person getPersonById(int id) {
        return personDAO.getById(id);
    }

    public void addPerson(Person person) {
        personDAO.add(person);
    }

    public void updatePerson(Person person) {
        personDAO.update(person);
    }

    public void deletePerson(int id) {
        personDAO.delete(id);
    }
}
