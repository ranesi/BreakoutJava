package breakout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by richa on 5/4/2017.
 */
public class MenuGUI extends JFrame {
    private JPanel rootPanel;
    private JButton newGameButton;
    private JButton scoresButton;
    private JButton quitButton;

    MenuGUI(){
        initGUI();
        addListeners();
    }

    private void initGUI(){
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setTitle("Breakout 2k7");
        setSize(new Dimension(200, 300));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addListeners(){
        newGameButton.addActionListener(e -> {
            Music music = new Music();
            EventQueue.invokeLater(() -> {
                Breakout game = new Breakout();
                game.setVisible(true);
                music.start();
            });
        });

        scoresButton.addActionListener(e -> {

        });

        quitButton.addActionListener(e -> this.dispose());
    }
}
