package breakout;

/**
 * Created by richa on 5/4/2017.
 */
public class Level implements Constants {
    private boolean[] level;

    Level(){
        level = new boolean[BRICK_NUM];
        // TODO read level from database
    }
}
