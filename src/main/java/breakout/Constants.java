package breakout;

/**
 * Created by richa on 4/25/2017.
 */
public interface Constants {

    /////////GAME STUFF//////////
    int WIDTH = 400;
    int HEIGHT = 400;
    int BOTTOM_EDGE = 390;
    int BRICK_NUM = 80;
    int INIT_PADDLE_X = 200;
    int INIT_PADDLE_Y = 340;
    int INIT_BALL_X = 230;
    int INIT_BALL_Y = 300;
    int DELAY = 1000;
    int PERIOD = 5;
    /////////////////////////////

    /////////DB STUFF////////////
    String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_NAME = "breakout";
    String DB_URL = "jdbc:mysql://localhost:3306/";
    String DB_USER = "ranesi";
    String DB_AUTH_FILE = "info.txt";
}
