package org.example.utils;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class EmployeeTableModel extends AbstractTableModel {
    private String[] columns;
    private Object[][] rows;

    public EmployeeTableModel(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee[] employees = employeeDAO.getAll().toArray(new Employee[0]);
        columns = new String[]{"ID", "FIRSTNAME", "LASTNAME", "ROLE", "DEPARTMENT"};
        rows = new Object[employees.length][columns.length];

        for (int i = 0; i < employees.length; i++) {
            rows[i][0] = employees[i].getId();
            rows[i][1] = employees[i].getFirstname();
            rows[i][2] = employees[i].getLastname();
            rows[i][3] = employees[i].getRole();
            rows[i][4] = employees[i].getDepartment().getName();
        }
    }
    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
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

    public void setData(Object[][] data) {
        this.rows = data;
        fireTableDataChanged();
    }
}
