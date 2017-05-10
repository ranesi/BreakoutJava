package breakout;

import java.util.ArrayList;
import java.util.Random;
/**
 * Created by richa on 5/4/2017.
 */
public class Level implements Constants {
    private int[][] level;
    private ArrayList<int[][]> levels;
    private Random random;

    Level(){
        random = new Random();
        levels = new ArrayList<>();

        levels.add(new int[][]{
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0},
                {2,2,2,0,0,2,2,2},
        });

        levels.add(new int[][]{
                {1,1,1,1,1,1,1,1},
                {2,1,1,1,1,1,1,2},
                {1,1,1,1,1,1,1,1},
                {1,2,2,1,1,2,2,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,2,2,1,1,1},
                {1,1,1,1,1,1,1,1},
                {2,2,1,1,1,1,2,2},
                {1,0,0,0,0,0,0,1},
                {1,1,1,0,0,1,1,1},
        });

        levels.add(new int[][]{
                {2,2,2,2,2,2,2,2},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
        });


    }

    public int[][] getLevel(){
        int index = random.nextInt(levels.size());
        return levels.get(index);
    }


}
