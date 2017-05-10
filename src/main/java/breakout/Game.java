package breakout;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by richa on 4/25/2017.
 */
public class Game extends JPanel implements Constants {

    //VERY STRONGLY based on the example provided at http://zetcode.com/tutorials/javagamestutorial/breakout/

    private Timer timer;
    private Projectile ball;
    private Bat paddle;
    private Brick[] bricks;
    private int score;
    private int counter;
    private boolean inGame = true;
    private boolean win = false;
    private int[][] level;
    private int invulnerableBricks = 0;

    public Game() {
        initFrame();
    }

    private void initFrame() {
        //initialize playfield
        addKeyListener(new TAdapter());
        setFocusable(true);

        //get level
        Level levelGenerator = new Level();
        level = levelGenerator.getLevel();

        //initialize scoring
        score = 100;
        counter = 0;

        //create brick array
        bricks = new Brick[BRICK_NUM];

        //JFrame setup
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        //instantiate, configure timer
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);
    }

    @Override
    public void addNotify(){
        super.addNotify();
        gameInit();
    }

    private void gameInit() {
        ball = new Projectile();
        paddle = new Bat();

        //BUILD LEVEL
        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j ++) {
                if (level[i][j] == AIR) {
                    bricks[k] = new Brick(j * 40 + 30, i * 10 + 50, true, true);
                } else if (level[i][j] == BRICK) {
                    bricks[k] = new Brick(j * 40 + 30, i * 10 + 50, false, true);
                } else if (level[i][j] == I_BRICK) {
                    bricks[k] = new Brick(j * 40 + 30, i * 10 + 50, false, false);
                    invulnerableBricks++;
                }
                k++;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (inGame)
            drawObjects(g2d);
        else
            gameOver(g2d);

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {
        // draw images based on location

        Font font = new Font("Courier New", Font.PLAIN, 12);
        FontMetrics fm = this.getFontMetrics(font);
        g2d.setColor(Color.BLACK);

        // draw score
        g2d.drawString("Score: " + Integer.toString(score),
                (Constants.WIDTH / fm.stringWidth("Score: " + Integer.toString(score))) / 2,
                Constants.HEIGHT / 2 + 160);
        g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), this);
        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), this);

        // draw bricks which are NOT destroyed
        for (int i = 0; i < BRICK_NUM; i++) {
            if (!bricks[i].isDestroyed())
                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(), bricks[i].getY(), bricks[i].getWidth(), bricks[i].getHeight(), this);
        }
    }

    private void gameOver(Graphics2D g2d){
        //display text
        String scoreString = "Final Score: " + Integer.toString(score);

        Font font = new Font("Courier New", Font.BOLD, 18);
        FontMetrics metr = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString("Final Score: " + Integer.toString(score),
                (Constants.WIDTH - metr.stringWidth(scoreString)) / 2,
                Constants.HEIGHT / 2);
        if (win) {
            DB.preparedInsert(Integer.toString(score));
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            ball.move();
            paddle.move();
            checkCollision();
            repaint();
            counter++;
            if (counter == 350){
                // Decrease score, reset counter to 0
                score--;
                counter = 0;
            }
        }

        private void stopGame() {
            inGame = false;
            timer.cancel();
        }

        private void checkCollision() {
            if (ball.getRectangle().getMaxY() > Constants.BOTTOM_EDGE)
                stopGame();
            for (int i = 0, j = 0; i < BRICK_NUM; i++) {
                if (bricks[i].isDestroyed())
                    j++;
                if (j + invulnerableBricks == BRICK_NUM) {
                    win = true;
                    stopGame();
                }
            }

            if ((ball.getRectangle().intersects(paddle.getRectangle()))) {

                int batLeftmostPosition = (int) paddle.getRectangle().getMinX();
                int projectileLeftmostPosition = (int) ball.getRectangle().getMinX();

                // determine delfection of ball
                int first = batLeftmostPosition + 8;
                int second = batLeftmostPosition + 16;
                int third = batLeftmostPosition + 24;
                int fourth = batLeftmostPosition + 32;

                if (projectileLeftmostPosition < first) {
                    ball.setXDir(-1);
                    ball.setYDir(-1);
                }

                if (projectileLeftmostPosition >= first && projectileLeftmostPosition < second) {
                    ball.setXDir(-1);
                    ball.setYDir(-1 * ball.getYDir());
                }

                if (projectileLeftmostPosition >= second && projectileLeftmostPosition < third) {
                    ball.setXDir(0);
                    ball.setYDir(-1);
                }

                if (projectileLeftmostPosition >= third && projectileLeftmostPosition < fourth) {
                    ball.setXDir(1);
                    ball.setYDir(-1 * ball.getYDir());
                }

                if (projectileLeftmostPosition > fourth) {
                    ball.setXDir(1);
                    ball.setYDir(-1);
                }
            }

            for (int i = 0; i < BRICK_NUM; i++) {
                if ((ball.getRectangle()).intersects(bricks[i].getRectangle())) {
                    // get dimensions of ball
                    int ballLeft = (int)ball.getRectangle().getMinX();
                    int ballHeight = (int)ball.getRectangle().getHeight();
                    int ballWidth = (int)ball.getRectangle().getWidth();
                    int ballTop = (int)ball.getRectangle().getMinY();

                    // determine where the ball is
                    Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                    Point pointLeft = new Point(ballLeft - 1, ballTop);
                    Point pointTop = new Point(ballLeft, ballTop - 1);
                    Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                    // determines which direction to deflect ball, destroy brick
                    if (!bricks[i].isDestroyed()) {
                        if (bricks[i].getRectangle().contains(pointRight))
                            ball.setXDir(-1);
                        else if (bricks[i].getRectangle().contains(pointLeft))
                            ball.setXDir(1);

                        if (bricks[i].getRectangle().contains(pointTop))
                            ball.setYDir(1);
                        else if (bricks[i].getRectangle().contains(pointBottom))
                            ball.setYDir(-1);

                        if (bricks[i].isDestroyable()) {
                            bricks[i].setDestroyed(true);
                        }
                    }
                }
            }
        }
    }
}
