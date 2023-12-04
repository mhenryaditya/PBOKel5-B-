package mainapk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrialConnect {

    public static Connection conn;

    public static Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/database_pbo", user = "root", pass = "";
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(TrialConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
}
