package breakout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by richa on 4/25/2017.
 */
public class Music extends Thread {
    @Override
    public void run() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("smooth.wav"));
            Clip smooth = AudioSystem.getClip();

            smooth.open(ais);
            smooth.start();

            while(!smooth.isRunning())
                Thread.sleep(10);
            while(smooth.isRunning())
                Thread.sleep(10);

            smooth.close();

        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
