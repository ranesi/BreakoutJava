package breakout;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by richa on 5/4/2017.
 */
public class Level implements Constants {
    private boolean[][] level;
    private ArrayList<boolean[][]> levels;
    private Random random;

    Level(){
        random = new Random();
        levels = new ArrayList<>();

        levels.add(new boolean[][]{
                {false, false, false, false, false, false, false, false},
                {false, true, true, false, true, true, true, false},
                {false, true, true, false, true, true, true, false},
                {false, false, false, false, false, false, false, false},
                {true, true, true, false, true, true, true, false},
                {true, true, true, false, true, true, true, false},
                {true, true, true, false, true, true, true, false},
                {true, true, true, false, true, true, true, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
        });
        levels.add(new boolean[][]{
                {false, true, false, true, false, true, false, true},
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {true, false, true, false, true, false, true, false},
                {false, true, false, true, false, true, false, true},
                {true, true, true, true, true, true, true, true},
        });
        levels.add(new boolean[][]{
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false, false}
        });

    }

    public boolean[][] getLevel(){
        int index = random.nextInt(levels.size());
        return levels.get(index);
    }


}
