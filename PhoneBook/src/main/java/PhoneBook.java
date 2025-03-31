
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author arman
 */
public class PhoneBook {

    JTextField jtfName;
    JTextField jtfNumber;

    JCheckBox jcbIgnoreCase;

    JRadioButton jrbExactMatch;
    JRadioButton jrbStartWith;
    JRadioButton jrbEndWith;

    String[][] phonelist = {
        {"John", "555-8765"},
        {"Jessica", "555-5643"},
        {"Adam", "555-1212"},
        {"Reachel", "555-3435"},
        {"Tom & Jerry", "555-1001"}
    };

    private PhoneBook() {

        JFrame jf = new JFrame("My Phonebook");
        JPanel jp = new JPanel();
        jp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //Setting GridLayout with 0 rows and 1 columns to JPanel.
        jp.setLayout(new GridLayout(0, 1));

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        JLabel jlbName = new JLabel("Name");
        JLabel jlbNumber = new JLabel("Number");

        jlbName.setLabelFor(jtfName);
        jlbNumber.setLabelFor(jtfNumber);

        //Name Field
        jtfName = new JTextField(30);
        jtfName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Look for number
                String name = jtfName.getText();
                lookupNumber(name);
            }

        });
        //Number Field
        jtfNumber = new JTextField(30);
        jtfNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = jtfNumber.getText();
                lookupName(number);
            }

        });

        JLabel jlbSearchOption = new JLabel("Search Option");

        jcbIgnoreCase = new JCheckBox("Ignore Case");

        ButtonGroup bG = new ButtonGroup();

        jrbExactMatch = new JRadioButton("Exact Match");
        jrbStartWith = new JRadioButton("Start With", true);
        jrbEndWith = new JRadioButton("End With");

        bG.add(jrbExactMatch);
        bG.add(jrbStartWith);
        bG.add(jrbEndWith);

        //Adding components to JPanel
        jp.add(jlbName);
        jp.add(jtfName);

        jp.add(jlbNumber);
        jp.add(jtfNumber);

        jp.add(jlbSearchOption);

        jp.add(jcbIgnoreCase);

        jp.add(jrbExactMatch);
        jp.add(jrbStartWith);
        jp.add(jrbEndWith);

        //Adding JPanel to JFrame
        jf.add(jp);

        jf.pack();

    }

    public void lookupName(String lookupNumber) {

        for (String[] phoneRecord : phonelist) {

            String contactName = phoneRecord[0];
            String contactNumber = phoneRecord[1];

            //Check with Exact match
            if (jrbExactMatch.isSelected()) {
                if (contactNumber.equals(lookupNumber)) {
                    jtfName.setText(contactName);
                }
            } //Check StartWith
            else if (jrbStartWith.isSelected()) {
                if (contactNumber.startsWith(lookupNumber)) {
                    jtfName.setText(contactName);
                }
            } //Check EndWith
            else {
                if (contactNumber.endsWith(lookupNumber)) {
                    jtfName.setText(contactName);
                }
            }

        }
    }

    public void lookupNumber(String lookupName) {

        String lookupNameTrimmed = lookupName.trim();

        for (int i = 0; i < phonelist.length; i++) {

            //trimming the name and number
            String contactName = phonelist[i][0];
            String contactNumber = phonelist[i][1];

            //Ignoring Case
            if (jcbIgnoreCase.isSelected()) {

                String lookupNameLowerCase = lookupNameTrimmed.toLowerCase();
                String contactNameLowerCase = contactName.toLowerCase();

                //Exact match
                if (jrbExactMatch.isSelected()) {
                    //Lookup Matched
                    if (contactNameLowerCase.equals(lookupNameLowerCase)) {
                        System.out.println("" + contactName + " " + contactNumber);
                        jtfNumber.setText(contactNumber);
                        break;
                    } else {
                        continue;
                    }
                } //Starts with
                else if (jrbStartWith.isSelected()) {
                    //Lookup Matched
                    if (contactNameLowerCase.startsWith(lookupNameLowerCase)) {
                        System.out.println("" + contactName + " " + contactNumber);
                        jtfNumber.setText(contactNumber);
                        break;
                    } else {
                        continue;
                    }
                } //Ends with
                else {
                    if (contactNameLowerCase.endsWith(lookupNameLowerCase)) {
                        System.out.println("" + contactName + " " + contactNumber);
                        jtfNumber.setText(contactNumber);
                        break;
                    } else {
                        continue;
                    }
                }
            } else //Not Ignoring Case
            {
                if (jrbExactMatch.isSelected()) {
                    //Lookup Matched
                    if (contactName.equals(lookupName)) {
                        jtfNumber.setText(contactNumber);
                        break;
                    } else {
                        continue;
                    }
                } //Starts with
                else if (jrbStartWith.isSelected()) {
                    //Lookup Matched
                    if (contactName.startsWith(lookupName)) {
                        jtfNumber.setText(contactNumber);
                        return;
                    } else {
                        break;
                    }
                } //Ends with
                else {
                    if (contactName.endsWith(lookupName)) {
                        jtfNumber.setText(contactNumber);
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhoneBook();
            }
        });

    }
}
