package snakedemo.userinterface;

import javax.swing.JFrame;

import static snakedemo.constants.GameConstants.GAME_TITLE;

public class GameFrame extends JFrame{

    public GameFrame(){

        this.add(new GamePanel());
        this.setTitle(GAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
