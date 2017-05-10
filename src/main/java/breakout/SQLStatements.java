package breakout;

/**
 * Created by richa on 5/4/2017.
 */
public interface SQLStatements {

    // Interface to keep raw SQL out of the Database class
    String DROP_TABLE = "DROP TABLE IF EXISTS scores";
    String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS scores (id INT AUTO_INCREMENT, score VARCHAR(255), PRIMARY KEY (id))";
    String SELECT_ALL = "SELECT * FROM scores";
    String INSERT_INTO = "INSERT INTO scores VALUES (NULL, ?)";

}