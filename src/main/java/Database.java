import java.sql.*;

public class Database {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    Database() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentLogin", "root", "root123");
            preparedStatement = connection.prepareStatement("select * from Login where username=? and password=?");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Boolean checkLogin(String uName, String pwd) {

        try {

            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, pwd);

            resultSet=preparedStatement.executeQuery();

            if(resultSet.next())
                return true;
            else
                return false;
        }

        catch (Exception e) {

            System.out.println("error while validating"+e);
            return false;
        }

    }
}
