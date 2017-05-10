package breakout;

import javax.swing.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Sprite {

    int x;
    int y;
    int iWidth;
    int iHeight;
    Image image;

    void setX(int x) {
        this.x = x;
    }

    int getX() {
        return x;
    }

    void setY(int y) {
        this.y = y;
    }

    int getY() {
        return y;
    }

    int getWidth() {
        return iWidth;
    }

    int getHeight() {
        return iHeight;
    }

    Image getImage() {
        return image;
    }

    Rectangle getRectangle() {
        return new Rectangle(x, y,
                image.getWidth(null), image.getHeight(null));
    }
}


