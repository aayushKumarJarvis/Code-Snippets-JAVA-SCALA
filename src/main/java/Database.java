import java.sql.*;

public class Database {

    Connection connection;
    PreparedStatement preparedStatementForLoginCheck;
    PreparedStatement preparedStatementForRegisterData;
    ResultSet resultSetForLogin;

    Database() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLogin", "root", "root123");
            preparedStatementForLoginCheck = connection.prepareStatement("select * from Login where username=? and password=?");
            preparedStatementForRegisterData = connection.prepareStatement("INSERT INTO Login(username,password) VALUES(?,?)");
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    public Boolean checkLogin(String uName, String pwd) {

        try {

            preparedStatementForLoginCheck.setString(1, uName);
            preparedStatementForLoginCheck.setString(2, pwd);

            resultSetForLogin=preparedStatementForLoginCheck.executeQuery();

            if(resultSetForLogin.next())
                return true;
            else
                return false;
        }

        catch (Exception e) {

            System.out.println("error while validating"+e);
            return false;
        }

    }

    public Boolean registerData(String uName, String pwd) {

        try {

            preparedStatementForRegisterData.setString(1,uName);
            preparedStatementForRegisterData.setString(2, pwd);

            int result = preparedStatementForRegisterData.executeUpdate();

            if(result != 0)
                return true;
            else
                return false;
        }

        catch (Exception e) {

            System.out.println("User not registerd" + e);
            return false;
        }
    }
}
