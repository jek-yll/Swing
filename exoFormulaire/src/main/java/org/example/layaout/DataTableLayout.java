package org.example.layaout;

import lombok.Data;

import javax.swing.*;

@Data
public class DataTableLayout {

    JScrollPane scrollPane;
    private JTable dataTable;

    public DataTableLayout(){

        String rows[][]={{""}};
        String column[] = {"Nom", "Email", "Genre"};
        dataTable = new JTable(rows, column);
        scrollPane = new JScrollPane(dataTable);

    }

}
