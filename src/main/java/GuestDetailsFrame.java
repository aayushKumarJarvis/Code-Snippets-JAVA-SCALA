
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuestDetailsFrame extends JFrame {

    JLabel nameOfCustomer,
            addressOfCustomer,
            idCodeOfCustomer,
            mobileNumber,

    purposeOfVisit,
            checkINTime,
            checkOUTTime,

    roomNumber,search;

    JTextField nameTextField,
            addressTextField,

    idCodeTextField,
            mobileTextField,

    purposeOfVisitTextField,
            checkINTextField,

    checkOutTextField,
            roomNumberTextField,

               searcht;

    JButton buttonForRegister, buttonForSearch;

    GuestDetailsFrame() {

        setExtendedState(MAXIMIZED_BOTH); // Occupying the Full Size of the window.

        setTitle("LNMIIT GuestHouse Record");
        setLayout(new GridBagLayout()); //

        getContentPane().setBackground(Color.gray);

        nameOfCustomer = new JLabel("Name of Customer");
        addressOfCustomer = new JLabel("Address Details");

        idCodeOfCustomer = new JLabel("ID-proof Code");
        mobileNumber = new JLabel("Mobile No.");
        purposeOfVisit = new JLabel("Purpose of Visit");

        checkINTime = new JLabel("Check-in Date"); // TO be used as System Time
        checkOUTTime = new JLabel("Check-out Date");
        roomNumber = new JLabel("Room No.");

        search = new JLabel("Search");

        nameTextField = new JTextField(20);
        addressTextField = new JTextField(20);
        idCodeTextField = new JTextField(20);
        mobileTextField = new JTextField(20);
        purposeOfVisitTextField = new JTextField(20);
        checkINTextField = new JTextField(20);
        checkOutTextField = new JTextField(20);
        roomNumberTextField = new JTextField(20);

        searcht = new JTextField(30);

        buttonForRegister = new JButton("Register for Guest House");
        buttonForSearch = new JButton("Search for Customers");

        GridBagConstraints layoutOfGridBagConstraints = new GridBagConstraints();

        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 0;
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(nameOfCustomer,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 0;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(nameTextField,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 1;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;

        add(addressOfCustomer,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 1;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(addressTextField,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 2;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;

        add(idCodeOfCustomer,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 2;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(idCodeTextField,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 3;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;

        add(mobileNumber,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 3;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(mobileTextField,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 4;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;

        add(purposeOfVisit,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 4;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(purposeOfVisitTextField,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 5;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;

        add(checkINTime,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 5;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(checkINTextField,layoutOfGridBagConstraints);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date dateFormatObject = new Date();

        checkINTextField.setText(dateFormat.format(dateFormatObject));
        checkINTextField.setEditable(false);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 6;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;

        add(checkOUTTime,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 6;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(checkOutTextField,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 7;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);
        layoutOfGridBagConstraints.anchor = GridBagConstraints.WEST;

        add(roomNumber,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 7;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(roomNumberTextField,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 8;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(buttonForRegister,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 0;
        layoutOfGridBagConstraints.gridy = 9;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(search,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 9;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(searcht,layoutOfGridBagConstraints);

        layoutOfGridBagConstraints = new GridBagConstraints();
        layoutOfGridBagConstraints.gridx = 1;
        layoutOfGridBagConstraints.gridy = 10;
        layoutOfGridBagConstraints.insets = new Insets(10,10,10,10);

        add(buttonForSearch, layoutOfGridBagConstraints);

        buttonForRegister.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int flagForDataCheckONE = 0;
                int flagForDataCheckTWO = 0;

                String name = nameTextField.getText();
                name = name.toUpperCase();

                for (int i = 0; i < name.length(); i++) {

                    if ((name.charAt(i) < 65 || name.charAt(i) > 90) && name.charAt(i) != 32) {

                        JOptionPane.showMessageDialog(new JFrame(), "Name Constraints Violated !!", "Error", JOptionPane.ERROR_MESSAGE);
                        flagForDataCheckTWO = 1;
                    }
                }

                String address = addressTextField.getText();
                String idcode = idCodeTextField.getText();
                String mobile = mobileTextField.getText();

                if (mobile.length() != 10) {
                    JOptionPane.showMessageDialog(new JFrame(), "Mobile Number Constraints Violated !!", "Error", JOptionPane.ERROR_MESSAGE);
                    flagForDataCheckONE = 1;
                }

                if (flagForDataCheckONE == 1 || flagForDataCheckTWO == 1) {

                    setVisible(false);
                    new GuestDetailsFrame();
                }

                String purpose = purposeOfVisitTextField.getText();
                String check_in = checkINTextField.getText();
                String check_out = checkOutTextField.getText();
                String room = roomNumberTextField.getText();

                try {

                    if (flagForDataCheckONE == 0 && flagForDataCheckTWO == 0) {

                        DatabaseConnectivity.insert(name, address, idcode, mobile, purpose, check_in, check_out, room);
                        JOptionPane.showMessageDialog(new JFrame(), "Update successful");
                        setVisible(false);
                    }

                }

                catch (ClassNotFoundException ex) {
                    Logger.getLogger(GuestDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                catch (SQLException ex) {
                    Logger.getLogger(GuestDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        buttonForSearch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String str = searcht.getText();

                try {
                    if (str.length() == 0 || !DatabaseConnectivity.search(str))
                        JOptionPane.showMessageDialog(new JFrame(), "cannot find", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                catch (ClassNotFoundException ex) {
                    Logger.getLogger(GuestDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                catch (SQLException ex) {
                    Logger.getLogger(GuestDetailsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {

        new GuestDetailsFrame();

    }
}
