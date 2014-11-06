import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginJFrame extends JFrame {

    JLabel userName;
    JLabel password;

    JTextField textUserName;
    JPasswordField textPassword;

    JButton buttonForLogin;
    JButton buttonForRegister;
    Container container;

    handlerForLogin handleLogin;
    handlerForRegister handleRegister;
    Database db;

    LoginJFrame() {

        super("Login Form");
        container = getContentPane();
        container.setLayout(new FlowLayout());

        db = new Database();
        handleLogin = new handlerForLogin();
        handleRegister = new handlerForRegister();

        userName = new JLabel("Username");
        password = new JLabel("Password");
        textUserName = new JTextField(10);
        textPassword = new JPasswordField(10);
        buttonForLogin = new JButton("Login");
        buttonForRegister = new JButton("Register");

        buttonForLogin.addActionListener(handleLogin);
        buttonForRegister.addActionListener(handleRegister);

        container.add(userName);
        container.add(password);
        container.add(textUserName);
        container.add(textPassword);
        container.add(buttonForLogin);
        container.add(buttonForRegister);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 130);

    }

    public class handlerForLogin implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if(ae.getSource() == buttonForLogin) {

                char[] temp_pwd = textPassword.getPassword();
                String pwd = null;
                pwd = String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:"+textUserName.getText()+","+pwd);

                if(db.checkLogin(textUserName.getText(), pwd)) {

                    JOptionPane.showMessageDialog(null, "You have logged in successfully","Success",
                    JOptionPane.INFORMATION_MESSAGE);
                }

                else {

                    JOptionPane.showMessageDialog(null, "Username/Password not entered or Incorrect!","Failed!!",
                    JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

    public class handlerForRegister implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == buttonForRegister) {

                char[] temp_pwd = textPassword.getPassword();
                String pwd = null;
                pwd = String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:" + textUserName.getText() + "," + pwd);

                if(db.registerData(textUserName.getText(), pwd)) {

                    JOptionPane.showMessageDialog(null, "You have been successfully registered","Success",
                    JOptionPane.INFORMATION_MESSAGE);
                }

                else {

                    JOptionPane.showMessageDialog(null, "Registration Unsuccessfull","Failed",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String args[])
    {
        LoginJFrame sample = new LoginJFrame();
    }
}



