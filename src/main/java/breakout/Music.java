package breakout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class Music extends Thread {
    private volatile boolean flag = true;
    @Override
    public void run() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("smooth.wav"));
            Clip smooth = AudioSystem.getClip();

            smooth.open(ais);
            smooth.start();
            while (flag) {
                // from stackoverflow -> http://stackoverflow.com/questions/36212563
                Thread.sleep(10);
            }
            smooth.stop();
            smooth.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public void stopMusic(){
        flag = false;
    }
}
