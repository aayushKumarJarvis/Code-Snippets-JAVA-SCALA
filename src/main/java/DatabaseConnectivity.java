import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnectivity {

    static final String JDBCDriver = "com.mysql.jdbc.Driver";
    static final String databaseURL = "jdbc:mysql://localhost/guest";
    static final String userName = "root";
    static final String passWord = "root123";


    public static void insert(String name,String add,String id,String mob,String pur,String in,String out,String room) throws ClassNotFoundException, SQLException{

        Class.forName(JDBCDriver);
        Connection connectionObject = DriverManager.getConnection(databaseURL, userName, passWord);

        PreparedStatement ps = connectionObject.prepareStatement("insert into guest_tb (name,address,idproof,mobileno,purposeofvisit,checkindate,checkoutdate,room) values (?,?,?,?,?,?,?,?)");

        ps.setString(1, name);
        ps.setString(2, add);

        ps.setString(3, id);
        ps.setString(4, mob);

        ps.setString(5, pur);
        ps.setString(6, in);

        ps.setString(7, out);
        ps.setString(8, room);

        ps.executeUpdate();
    }

    public static boolean search(String str) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(databaseURL, userName, passWord);
        String sql = "select * from guest_tb where name like ? or mobileno like ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,"%"+str+"%");
        ps.setString(2,"%"+str+"%");

        ResultSet rs = ps.executeQuery();
        int flagForSearch = 0;

        while(rs.next()) {

            String name = rs.getString("name");
            String add = rs.getString("address");
            String room = rs.getString("room");
            String mob= rs.getString("mobileno");

            JOptionPane.showMessageDialog(new Frame(),"Name = "+name+"\nAddress = "+add+"\nRoom No = "+room+"\nMobile No. = "+mob);
            flagForSearch = 1;
        }

        if(flagForSearch == 1)
            return true;
        else
            return false;
    }
}
