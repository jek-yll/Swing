package org.example.component;

import lombok.Data;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@Data
public class Table {
    JScrollPane scrollPane;
    private JTable tb;

    public Table(){

        String rows[][] = {
                {"100", "Pierre", "65000"},
                {"101", "Paul", "55100"},
                {"102", "Jacques", "82250"},
                {"103", "Henry", "82250"},
        };

        String column[] = {"ID", "NAME", "POINTS"};

        tb = new JTable(rows,column);

        tb.setBounds(30,40,500,500);

        scrollPane = new JScrollPane(tb);

        tb.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()){

                    int row = tb.getSelectedRow();

                    if(row<0){

                        System.out.println("y a rien");

                    } else {

                        int modelRow = tb.convertRowIndexToModel(row);

                        System.out.println(
                                String.format("Info selected in: %d . Dans model : %d. Autre info %s, %s, %s",
                                        row, modelRow,
                                        tb.getModel().getValueAt(modelRow, 0),
                                        tb.getModel().getValueAt(modelRow, 1),
                                        tb.getModel().getValueAt(modelRow, 2))
                        );
                    }
                }
            }
        });
    }
}
