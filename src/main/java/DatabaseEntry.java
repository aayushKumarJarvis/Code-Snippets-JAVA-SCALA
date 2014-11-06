import java.sql.*;

public class DatabaseEntry {

    Connection conn = null;
    String[] guestInfo;

    DatabaseEntry(String[] guestDetails) {

        guestInfo = guestDetails;
        try{
            conn = DatabaseConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO guest_details VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, null);
            for(int i=0;i<8;i++){
                ps.setString(i+2, guestInfo[i]);
            }
            ps.executeUpdate();
            System.out.println("Data Entered");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
