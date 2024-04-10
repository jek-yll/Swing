package org.example.utils;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

import javax.swing.table.DefaultTableModel;

public class EmployeeTableModel  {
    private String[] columns;
    private Object[][] rows;

    public EmployeeTableModel(){
        DefaultTableModel model = new DefaultTableModel();
        columns = new String[]{"ID", "FIRSTNAME", "LASTNAME", "ROLE", "DEPARTMENT"};
        rows = getData();
        model.addRow(rows);
        model.addColumn(columns);
    }

    private Object[][] getData(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee[] employees = employeeDAO.getAllEmployees().toArray(new Employee[0]);
        Object[][] data = new Object[employees.length][5];

        for (int i = 0; i < employees.length; i++) {
            data[i][0] = employees[i].getId();
            data[i][1] = employees[i].getFirstname();
            data[i][2] = employees[i].getLastname();
            data[i][3] = employees[i].getRole();
            data[i][4] = employees[i].getDepartment().getName();

        }

        return data;
    }

}
