package breakout;

import javax.swing.*;

/**
 * Created by richa on 4/25/2017.
 */
class Projectile extends Sprite implements Constants {

    private int xDir;
    private int yDir;

    Projectile() {
        xDir = 1;
        yDir = -1;

        ImageIcon ii = new ImageIcon("ball.png");
        image = ii.getImage();

        iWidth = image.getWidth(null);
        iHeight = image.getHeight(null);

        resetState();
    }

    void move() {

        x += xDir;
        y += yDir;

        if (x == 0)
            setXDir(1);

        if (x == WIDTH - iWidth)
            setXDir(-1);

        if (y == 0)
            setYDir(1);
    }

    private void resetState() {
        x = INIT_BALL_X;
        y = INIT_BALL_Y;
    }

    int getXDir() { return this.xDir; }
    void setXDir(int x){
        xDir = x;
    }

    int getYDir() { return this.yDir; }
    void setYDir(int y){
        yDir = y;
    }



}
