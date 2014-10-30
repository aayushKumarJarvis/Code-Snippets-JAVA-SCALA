import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginJFrame extends JFrame {

    JLabel userName;
    JLabel password;

    JTextField textUserName;
    JPasswordField textPassword;

    JButton button;
    Container container;

    handler handle;
    Database db;

    LoginJFrame() {

        super("Login Form");
        container = getContentPane();
        container.setLayout(new FlowLayout());

        db = new Database();
        handle = new handler();

        userName = new JLabel("Username");
        password = new JLabel("Password");
        textUserName = new JTextField(10);
        textPassword = new JPasswordField(10);
        button = new JButton("Login");

        button.addActionListener(handle);

        container.add(userName);
        container.add(password);
        container.add(textUserName);
        container.add(textPassword);
        container.add(button);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 130);

    }

    public class handler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if(ae.getSource() == button) {

                char[] temp_pwd = textPassword.getPassword();
                String pwd = null;
                pwd = String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:"+textUserName.getText()+","+pwd);

                if(db.checkLogin(textUserName.getText(), pwd)) {

                    JOptionPane.showMessageDialog(null, "You have logged in successfully","Success",
                    JOptionPane.INFORMATION_MESSAGE);
                }

                else {

                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
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



