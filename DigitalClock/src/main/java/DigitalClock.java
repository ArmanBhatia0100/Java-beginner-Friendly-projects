
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class DigitalClock extends JFrame {

    SimpleDateFormat timeformat;
    SimpleDateFormat dayformat;
    SimpleDateFormat dateformat;

    String time;
    String day;
    String date;

    JLabel labelTime;
    JLabel labelDay;
    JLabel labelDate;

    DigitalClock() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new BorderLayout(20, 5));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(400, 200));

        timeformat = new SimpleDateFormat("hh':'mm':'ss a");
        dayformat = new SimpleDateFormat("EE MMMM dd, YYYY");

        time = timeformat.format(Calendar.getInstance().getTime());
        day = dayformat.format(Calendar.getInstance().getTime());

        labelTime = new JLabel(time);
        labelTime.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
        labelTime.setBackground(Color.BLACK);
        labelTime.setForeground(Color.WHITE);
        labelTime.setOpaque(true);

        labelDay = new JLabel(day);
        labelDay.setFont(new Font("SANS_SERIF", Font.PLAIN, 35));

        this.add(labelTime, BorderLayout.NORTH);
        this.add(labelDay, BorderLayout.CENTER);
        this.pack();

        this.setVisible(true);

        setTimer();
    }

    void setTimer() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time = timeformat.format(Calendar.getInstance().getTime());
                labelTime.setText(time);
                day = dayformat.format(Calendar.getInstance().getTime());
                labelDay.setText(day);
//                date = dateformat.format(Calendar.getInstance().getTime());
//                labelDate.setText(date);
            }
        });

        timer.start();

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DigitalClock();
            }
        });

    }
}
