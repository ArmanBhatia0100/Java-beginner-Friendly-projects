/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package arman.taskmanager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author arman
 */
public class TaskManager implements ActionListener {

    DefaultListModel<String> listModel = new DefaultListModel<>();

    JFrame frame = new JFrame("Task Manager");
    JList<String> taskList = new JList<>(listModel);

    JPanel buttonPanel = new JPanel();
    JScrollPane listPanel = new JScrollPane();


    JTextField textField = new JTextField(30);

    JButton addBtn = new JButton("Add");
    JButton deleteBtn = new JButton("Delete");
    JButton doneBtn = new JButton("Mark Done");

    public TaskManager() {
        frame.setSize(550, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //textfield (NORTH)
        frame.add(textField, BorderLayout.NORTH);
        textField.setActionCommand("TaskFieldAction");
        textField.addActionListener(this);

        // Button Panel (Center)
        buttonPanel.add(addBtn);
        addBtn.addActionListener(this);
        buttonPanel.setPreferredSize(new Dimension(100, 50));
        frame.add(buttonPanel, BorderLayout.CENTER);

        // List (SOUTH)
        listPanel.setViewportView(taskList);
        listPanel.setPreferredSize(new Dimension(500, 100)); // Wider to match frame
        frame.add(listPanel, BorderLayout.SOUTH);

        //Add to the frame
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Enter on the TextField
        if (e.getActionCommand().equals("TaskFieldAction")) {
            addTask(textField.getText().trim());
        }
        
        //Click on Add button
        if(e.getActionCommand().equals("Add")){
          addTask(textField.getText().trim());
        }
    }

    private void addTask(String task) {
        System.out.println("added");
        listModel.addElement(task);
        // clear the text Field
        textField.setText(" ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskManager();
            }

        });
    }

}
