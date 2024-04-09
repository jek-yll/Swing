package org.example.Layout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TodoLayout extends JFrame {

    private JTextField inputTodo;
    private JList<String> todoList;
    private JPanel mainPanel, buttonPanel;
    private JButton addBtn, deleteBtn, completeBtn;
    private int selectedIndex;

    public TodoLayout(){

        this.setTitle("My first Todo_App with Swing !");
        this.setSize(500, 750);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        inputTodo = new JTextField();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);

        todoList.addListSelectionListener( e -> {
            if (!e.getValueIsAdjusting()){
                selectedIndex = todoList.getSelectedIndex();
                System.out.println(selectedIndex);
            }
        });


        addBtn = new JButton("add");
        addBtn.setIcon(resizeIcon("src/img/add-6884593_640.png", 32, 32));
        addBtn.addActionListener( e -> {
            addTodo(inputTodo.getText());
            inputTodo.setText("");
        });

        deleteBtn = new JButton("delete");
        deleteBtn.setIcon(resizeIcon("src/img/delete-2935433_640.png", 32, 32));
        deleteBtn.addActionListener(e -> {
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });

        completeBtn = new JButton("completed");
        completeBtn.setIcon(resizeIcon("src/img/check-6380867_640.png", 32, 32));
        completeBtn.addActionListener(e -> {
            int selectedIndex = todoList.getSelectedIndex();
            if (selectedIndex != -1) {
                String todo = listModel.getElementAt(selectedIndex);
                listModel.set(selectedIndex, "<html><strike>" + todo + "</strike></html>");
            }
        });

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(completeBtn);

        add(inputTodo, BorderLayout.NORTH);
        add(todoList, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            TodoLayout todoApp = new TodoLayout();
            todoApp.setVisible(true);
        });
    }
    private static ImageIcon resizeIcon(String imagePath, int width, int height) {
        try {
            Image img = ImageIO.read(new File(imagePath));
            Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImg);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void addTodo(String todo){
        DefaultListModel listModel = (DefaultListModel) todoList.getModel();
        listModel.addElement(todo);
    }
}
