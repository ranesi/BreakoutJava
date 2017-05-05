package breakout;

/**
 * Created by richa on 4/25/2017.
 */

import java.awt.*;
import javax.swing.*;

public class Breakout extends JFrame {

    //Copied from zetcode.com/tutorials/javagamestutorials/breakout

    public Breakout() {
        initGUI();
    }

    private void initGUI() {
        add(new Frame());
        setTitle("Game Test");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
