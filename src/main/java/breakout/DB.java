package breakout;

/**
 * Class used to interface with MySQL database
 */

import java.sql.*;

class DB implements Constants, SQLStatements {

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

        try {
            statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //////////////////////////////
            // For development purposes...
            statement.execute(DROP_TABLE);
            //////////////////////////////

            statement.execute(CREATE_TABLE);

            //////////////////////////////
            // For demonstration purposes...
            preparedInsert("27");
            preparedInsert("42");
            //////////////////////////////

            rs = statement.executeQuery(SELECT_ALL);

        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return null;
        }
        // Everything went well; return the result set!
        return rs;
    }

    static ResultSet selectAll() {
        try {
            rs = statement.executeQuery(SELECT_ALL);
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            return null;
        }
        return rs;
    }

    static void preparedInsert(String score) {
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT_INTO);
            ps.setString(1, score);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException se) {}
    }

    static void shutdownDatabase() {
        // Close ResultSet, Statement, and Connection objects
        try {
            if (rs != null)
                rs.close();
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}
