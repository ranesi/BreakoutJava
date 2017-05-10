package breakout;

import javax.swing.*;


class Brick extends Sprite {

    //VERY STRONGLY based on the example provided at http://zetcode.com/tutorials/javagamestutorial/breakout/

    private boolean destroyed;
    private boolean destroyable;

    Brick(int x, int y, boolean destroyed, boolean destroyable) {
        this.x = x;
        this.y = y;

        this.destroyable = destroyable;

        String filename = "brick.png";

        if (!destroyable)
            filename = "ibrick.png";

        ImageIcon ii = new ImageIcon(filename);
        image = ii.getImage();

        iWidth = image.getWidth(null);
        iHeight = image.getHeight(null);


        this.destroyed = destroyed;
    }

    boolean isDestroyed() {
        return destroyed;
    }

    boolean isDestroyable() { return destroyable; }

    void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

}

