/*
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

*/
/**
 * Created by bigDaDDy on 11/5/2014.
 *//*


public class InfoPageFrame extends JFrame{
    static Dimension windowSize = new Dimension(200, 300);
    JLabel[] labels = new JLabel[8];
    JButton bNext, bPrevious;
    String[] guestInfo;

    InfoPageFrame(String guestDetails[]){
        setLayout(new VerticalLayout());
        guestInfo = guestDetails;

        labels[0] = new JLabel("Name: " + guestInfo[0]); add(labels[0]);
        labels[1] = new JLabel("ID-CODE: " + guestInfo[1]); add(labels[1]);
        labels[2] = new JLabel("Mobile Number: " + guestInfo[2]); add(labels[2]);
        labels[3] = new JLabel("Address: " + guestInfo[3]); add(labels[3]);
        labels[4] = new JLabel("Check-IN: " + guestInfo[4]); add(labels[4]);
        labels[5] = new JLabel("Check-OUT: " + guestInfo[5]); add(labels[5]);
        labels[6] = new JLabel("Room: " + guestInfo[6]); add(labels[6]);
        labels[7] = new JLabel("Purpose: " + guestInfo[7]); add(labels[7]);

        bPrevious = new JButton("Previous");
        bPrevious.addActionListener(new ClickPrevious());
        bNext = new JButton("Next");
        bNext.addActionListener(new ClickNext());

        add(bPrevious);
        add(bNext);

        setTitle("Guest Details");
        setSize(windowSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public class ClickPrevious implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            try {

                DatabaseQuery.previous();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public class ClickNext implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            try {
                System.out.println("1");
                DatabaseQuery.next();
                System.out.println("2");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
*/
