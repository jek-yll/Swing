package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Data
public class TaquinLayout {

    private JPanel gridPanel;
    private GridBagConstraints gridBagConstraints;
    private JButton jButton;
    private GridBagLayout gridBagLayout;
    private int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public TaquinLayout(){
        gridPanel = new JPanel();
        gridBagLayout = new GridBagLayout();
        gridPanel.setLayout(gridBagLayout);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        createGrid();
    }

    private void createGrid(){
        int x = 0;
        int y = 0;

        mixArray(numbers);

        for (int n : numbers){
            JButton jButton0 = new JButton(String.valueOf(n));

            gridBagConstraints.gridx = x;
            gridBagConstraints.gridy = y;
            gridBagConstraints.weighty = 1;
            gridBagConstraints.weightx = 1;
            if ((x+1) % 4 == 0){
                y ++;
                x = 0;
            } else x ++;

            gridPanel.add(jButton0, gridBagConstraints);
            jButton0.addActionListener(e -> mooveNumber(jButton0));

        }
    }

    private void mooveNumber(JButton button){
        int x = gridBagLayout.getConstraints(button).gridx;
        int y = gridBagLayout.getConstraints(button).gridy;

        System.out.println(x + ";" + y);
    }

    private void mixArray(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {

            int randomI = random.nextInt(i + 1);

            int temp = arr[randomI];
            arr[randomI] = arr[i];
            arr[i] = temp;
        }
    }

}
