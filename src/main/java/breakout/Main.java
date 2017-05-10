package breakout;

import java.sql.ResultSet;

/**
 * Created by richa on 5/4/2017.
 */
public class Main {

    public static void main(String[] args) {
        ResultSet rs = DB.setup();
        if (rs == null) {
            DB.shutdownDatabase();
        }

        try {
            ScoreModel sm = new ScoreModel(rs);
            MenuGUI giu = new MenuGUI(sm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

    }

    public static void shutdownProgram() {
        DB.shutdownDatabase();
        System.exit(0);
    }
}
