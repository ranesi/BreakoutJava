package breakout;

import javax.swing.*;

/**
 * Created by richa on 4/25/2017.
 */
class Ball extends Sprite implements Constants {

    private int xDir;
    private int yDir;

    Ball() {
        xDir = 1;
        yDir = -1;

        ImageIcon ii = new ImageIcon("ball.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_height = image.getHeight(null);

        resetState();
    }

    void move() {

        x += xDir;
        y += yDir;

        if (x == 0)
            setXDir(1);

        if (x == WIDTH - i_width)
            setXDir(-1);

        if (y == 0)
            setYDir(1);
    }

    private void resetState() {
        x = INIT_BALL_X;
        y = INIT_BALL_Y;
    }

    void setXDir(int x){
        xDir = x;
    }

    void setYDir(int y){
        yDir = y;
    }

    int getXDir() { return this.xDir; }
    int getYDir() { return this.yDir; }
}