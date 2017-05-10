package breakout;

import javax.swing.*;
import java.awt.*;


public class MenuGUI extends JFrame {
    private JPanel rootPanel;
    private JButton newGameButton;
    private JButton quitButton;
    private JTable scoresTable;
    private JButton updateButton;
    private Music music = null;

    MenuGUI(ScoreModel sm){
        initGUI(sm);
        addListeners();
    }

    private void updateTable() {
        ScoreModel updateTable = new ScoreModel(DB.selectAll());
        scoresTable.setModel(updateTable);
        scoresTable.repaint();
    }

    private void initGUI(ScoreModel sm){
        // Initialize menu GUI
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setTitle("Breakout 2k7");
        setSize(new Dimension(800, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // init threads
        music = new Music();

        // table setup

        scoresTable.setModel(sm);
        scoresTable.setGridColor(Color.BLACK);
    }

    private void addListeners(){
        newGameButton.addActionListener(e -> {
            EventQueue.invokeLater(() -> {
                Breakout game = new Breakout();
                game.setVisible(true);
                // music.run();
            });
        });

        updateButton.addActionListener(e -> updateTable());

        quitButton.addActionListener(e -> Main.shutdownProgram());
    }
}
