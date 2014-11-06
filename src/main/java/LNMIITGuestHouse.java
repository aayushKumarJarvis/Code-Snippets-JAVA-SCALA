import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class LNMIITGuestHouse extends JFrame implements ActionListener {

    JLabel labelOne, labelTWO, labelTHREE, labelFOUR, labelFIVE, labelSIX, labelSEVEN, labelEIGHT, labelNINE, labelTEN;
    JTextField textFieldONE, textFieldTWO, textFieldTHREE, textFieldFOUR, textFieldFIVE, textFieldSIX, textFieldSEVEN;
    JButton buttonONE, buttonTWO;
    JPasswordField passwordONE, passwordTWO;

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String yourDate = dateFormat.format(date);

    LNMIITGuestHouse() {

        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration For Guest House in The LNMIIT");

        labelOne = new JLabel("Welcome to The LNMIIT:");
        labelOne.setForeground(Color.blue);
        labelOne.setFont(new Font("Serif", Font.BOLD, 20));

        labelTWO = new JLabel("Name:");
        labelTHREE = new JLabel("Address:");
        labelFOUR = new JLabel("ID Proof Code");
        labelFIVE = new JLabel("Confirm ID Proof Code");
        labelSIX = new JLabel("Check In Date:");
        labelSEVEN = new JLabel("Check Out Date");
        labelEIGHT = new JLabel("Phone No:");
        labelNINE = new JLabel("Purpose of Visit");
        labelTEN = new JLabel("Room Number");

        textFieldONE = new JTextField();
        textFieldTWO = new JTextField();
        passwordONE = new JPasswordField();
        passwordTWO = new JPasswordField();

        textFieldTHREE = new JTextField(yourDate);
        textFieldTHREE.setEditable(false);

        textFieldFOUR = new JTextField();
        textFieldFIVE = new JTextField();
        textFieldSIX = new JTextField();
        textFieldSEVEN = new JTextField();

        buttonONE = new JButton("Submit");
        buttonTWO = new JButton("Clear");

        buttonONE.addActionListener(this);
        buttonTWO.addActionListener(this);

        labelOne.setBounds(100, 30, 400, 30);
        labelTWO.setBounds(80, 70, 200, 30);
        labelTHREE.setBounds(80, 110, 200, 30);
        labelFOUR.setBounds(80, 150, 200, 30);
        labelFIVE.setBounds(80, 190, 200, 30);
        labelSIX.setBounds(80, 230, 200, 30);
        labelSEVEN.setBounds(80, 270, 200, 30);
        labelEIGHT.setBounds(80, 310, 200, 30);
        labelNINE.setBounds(80, 350, 200, 30);
        labelTEN.setBounds(80, 390, 200, 30);

        textFieldONE.setBounds(300, 70, 200, 30);
        textFieldTWO.setBounds(300, 110, 200, 30);
        passwordONE.setBounds(300, 150, 200, 30);
        passwordTWO.setBounds(300, 190, 200, 30);
        textFieldTHREE.setBounds(300, 230, 200, 30);
        textFieldFOUR.setBounds(300, 270, 200, 30);
        textFieldFIVE.setBounds(300, 310, 200, 30);
        textFieldSIX.setBounds(300, 350, 200, 30);
        textFieldSEVEN.setBounds(300, 390, 200, 30);

        buttonONE.setBounds(80, 460, 100, 30);
        buttonTWO.setBounds(190, 460, 100, 30);

        add(labelOne);

        add(labelTWO);
        add(textFieldONE);

        add(labelTHREE);
        add(textFieldTWO);

        add(labelFOUR);
        add(passwordONE);

        add(labelFIVE);
        add(passwordTWO);

        add(labelSIX);
        add(textFieldTHREE);

        add(labelSEVEN);
        add(textFieldFOUR);

        add(labelEIGHT);
        add(textFieldFIVE);

        add(labelNINE);
        add(textFieldSIX);

        add(labelTEN);
        add(textFieldSEVEN);

        add(buttonONE);
        add(buttonTWO);
    }

    public boolean checkForAlphabets(String word) {

        if(Pattern.matches("[a-zA-Z]+", word))
            return true;
        else
            return false;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonONE) {

            int x = 0;
            String s1 = textFieldONE.getText();
            String s2 = textFieldTWO.getText();

            char[] s3 = passwordONE.getPassword();
            char[] s4 = passwordTWO.getPassword();
            String s8 = new String(s3);
            String s9 = new String(s4);

            String s6 = textFieldFOUR.getText();
            String s7 = textFieldFIVE.getText();
            String s10 = textFieldSIX.getText();
            String s11 = textFieldSEVEN.getText();

            if (checkForAlphabets(s1) && (s7.length() == 10)) {

                try {

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GuestHouse", "root", "root123");

                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO Customers(nameOfCustomer,addressOfCustomer,idProofCode,checkInDate,checkOutDate,mobileNumber,visitPurpose,roomNumber) VALUES(?,?,?,?,?,?,?,?)");



                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setString(3, s8);
                    ps.setString(4, yourDate);
                    ps.setString(5, s6);
                    ps.setString(6, s7);
                    ps.setString(7, s10);
                    ps.setString(8, s11);

                    int result =  ps.executeUpdate();
                    x++;
                    if (x > 0 && result > 0) {

                        JOptionPane.showMessageDialog(buttonONE, "Data Saved Successfully");
                    }
                }
                catch (Exception ex) {

                    System.out.println(ex);
                }
            }
            else {

                JOptionPane.showMessageDialog(buttonONE, "Validations not followed");
            }
        }
        else
        {
            textFieldONE.setText("");
            textFieldTWO.setText("");
            passwordONE.setText("");
            passwordTWO.setText("");
            textFieldTHREE.setText("");
            textFieldFOUR.setText("");
            textFieldFIVE.setText("");
            textFieldSIX.setText("");
            textFieldSEVEN.setText("");
        }
    }

    public static void displayRecordsBasedOnName(String name) {

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GuestHouse", "root", "root123");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Customers WHERE nameOfCustomer="+name+"");
            System.out.println(ps);
            ResultSet result = ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            if (result.next()) {
                System.out.println("Name: "+rs.getString(1));
                System.out.println("Address: "+rs.getString(2));
                System.out.println("idProofCode: "+rs.getString(3));
                System.out.println("Check In Date: "+rs.getString(4));
                System.out.println("Check Out Date: "+rs.getString(5));
                System.out.println("Mobile Number: "+rs.getString(6));
                System.out.println("Visit Purpose: "+rs.getString(7));
                System.out.println("Room Number: "+rs.getString(8));
            }
            else
                System.out.println("No record found");
        } catch (Exception e) {

            System.out.println("SQL Error" + e);

        }
    }

    public static void displayRecordsBasedOnMobileNumber(String mobileNumber) {

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GuestHouse", "root", "root123");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Customers WHERE mobileNumber="+mobileNumber+"");
            ResultSet result = ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            if(rs.next()) {

                System.out.println("Name: "+rs.getString(1));
                System.out.println("Address: "+rs.getString(2));
                System.out.println("idProofCode: "+rs.getString(3));
                System.out.println("Check In Date: "+rs.getString(4));
                System.out.println("Check Out Date: "+rs.getString(5));
                System.out.println("Mobile Number: "+rs.getString(6));
                System.out.println("Visit Purpose: "+rs.getString(7));
                System.out.println("Room Number: "+rs.getString(8));
            }

            else
                System.out.println("No record found");
        }

        catch (Exception e) {

            System.out.println("SQL Error"+e);

        }
    }

    public static void main(String args[]) {

        new LNMIITGuestHouse();

       //displayRecordsBasedOnMobileNumber("9772536250");

       //displayRecordsBasedOnName("Aayush Kumar");



    }
}


