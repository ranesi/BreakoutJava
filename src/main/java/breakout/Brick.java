package breakout;

import javax.swing.*;


public class Brick extends Sprite {

    //VERY STRONGLY based on the example provided at http://zetcode.com/tutorials/javagamestutorial/breakout/

    private boolean destroyed;

    public Brick(int x, int y, boolean destroyed) {
        this.x = x;
        this.y = y;

        ImageIcon ii = new ImageIcon("brick.png");
        image = ii.getImage();

        iWidth = image.getWidth(null);
        iHeight = image.getHeight(null);

        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

}

