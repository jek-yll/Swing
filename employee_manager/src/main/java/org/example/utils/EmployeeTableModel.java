package org.example.utils;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EmployeeTableModel implements TableModel {
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
        Object[][] data = new Object[employees.length][4];

        for (int i = 0; i < employees.length; i++) {
            data[i][0] = employees[i].getId();
            data[i][1] = employees[i].getFirstname();
            data[i][2] = employees[i].getLastname();
            data[i][3] = employees[i].getRole();
            //data[i][4] = employees[i].getDepartment().getName();

        }
        return data;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
