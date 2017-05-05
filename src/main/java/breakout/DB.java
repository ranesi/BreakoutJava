package breakout;

/**
 * Class used to interface with MySQL database
 */

import java.sql.*;

public class DB implements Constants, SQLStatements {

    private static Connection conn = null;
    private static Statement statement = null;
    private static ResultSet rs = null;

    static ResultSet setup() {

        String[] dbAuth = FileIO.getAuth();
        String user = dbAuth[0], pwd = dbAuth[1];

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Abort: database driver error");
            return null;
        }

        try {
            conn = DriverManager.getConnection(DB_URL + DB_NAME, user, pwd);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return null;
        }

        //TODO finish this
        return null;
    }

}
