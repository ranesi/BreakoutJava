package breakout;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by richa on 4/25/2017.
 */
public class Bat extends Sprite implements Constants {

    //VERY STRONGLY based on the example provided at http://zetcode.com/tutorials/javagamestutorial/breakout/

    private int dx;

    public Bat() {

        ImageIcon ii = new ImageIcon("paddle.png");
        image = ii.getImage();

        iWidth = image.getWidth(null);
        iHeight = image.getHeight(null);

        resetState();
    }

    public void move() {
        x += dx;
        if (x <= 0)
            x = 0;
        if (x >= WIDTH - iWidth)
            x = WIDTH - iWidth;
    }

    public void keyPressed(KeyEvent e) {
        //key listener; determine movement etc.
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
            dx = -1;
        if (key == KeyEvent.VK_RIGHT)
            dx = 1;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
            dx = 0;
        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
    }

    private void resetState() {
        x = INIT_PADDLE_X;
        y = INIT_PADDLE_Y;
    }
}
