
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author arman
 */
public class ExpenseTracker implements ActionListener {

    private JTextField expenseField;
    private JTextField amountField;
    
    private DefaultListModel<String> listDataModel;
    private DefaultTableModel tableDataModel;
    private JComboBox<String> categoryComboBox;

    /*
    Add an expense with amount, category, and date.
Display a list of expenses.
Show total spending.
     */
    public ExpenseTracker() {
        //Frame and JPanes
        JFrame jf = new JFrame();

        // Expense Action Panel (NORTH)
        JPanel expenseActionPanel = new JPanel();

        JLabel expenseLabel = new JLabel("Expense: ");
        expenseField = new JTextField(60);
        amountField = new JTextField(10);
        
        

        String[] expenseCategory = {"Food", "Clothing", "Auto", "Home"};
        categoryComboBox = new JComboBox<>(expenseCategory);

        JButton addExpenseBtn = new JButton("Add");
        addExpenseBtn.addActionListener(this);
        expenseActionPanel.add(expenseLabel);
        expenseActionPanel.add(expenseField);
        expenseActionPanel.add(amountField);
        expenseActionPanel.add(categoryComboBox);
        expenseActionPanel.add(addExpenseBtn);
        jf.add(expenseActionPanel, BorderLayout.NORTH);

        // Expense List (CENTER)
        JScrollPane jScrollPane;

        Object[][] data = {};
        String[] columns = {"Expense", "Category", "Amount"};
        tableDataModel = new DefaultTableModel(data, columns);
        JTable table = new JTable(tableDataModel);
        table.setFillsViewportHeight(true);
        jScrollPane = new JScrollPane(table);
        jf.add(jScrollPane, BorderLayout.CENTER);

        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExpenseTracker();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            addExpense();
        }
    }

    private void addExpense() {
        String[] newExpense = {expenseField.getText(), categoryComboBox.getSelectedItem().toString(), amountField.getText()};
        tableDataModel.addRow(newExpense);
        
        //reset
        expenseField.setText("");
        amountField.setText("");
    }
}
