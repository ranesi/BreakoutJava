package breakout;

/**
 * Created by richa on 4/25/2017.
 */

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Breakout extends JFrame implements WindowListener {

    //VERY STRONGLY based on the example provided at http://zetcode.com/tutorials/javagamestutorial/breakout/

    Breakout() {
        initGUI();
    }

    private void initGUI() {
        add(new Game());
        setTitle("Game Test");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void windowClosing(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
