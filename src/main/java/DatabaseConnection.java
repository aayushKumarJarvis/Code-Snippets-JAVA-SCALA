import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/guest_house";
    static final String USER = "root";
    static final String PASS = "root";

    static Connection conn = null;
    static Statement stmt = null;

    static{													// connect only once make another class for database related queries
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        }
        catch(SQLException e){

        }
        catch(ClassNotFoundException e){

        }
    }

    public static Statement getStatement(){
        System.out.printf(stmt+" "+conn+"\n");
        return stmt;
    }

    public static Connection getConnection(){
        System.out.printf(stmt+" "+conn+"\n");
        return conn;
    }
}
