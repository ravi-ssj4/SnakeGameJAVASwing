package snakedemo.userinterface;

import javax.swing.*;

import static snakedemo.constants.GameConstants.*;

public class UserInterfaceImpl {
    private final JFrame jFrame;


    Timer timer;

    public UserInterfaceImpl() {
        this.jFrame = new JFrame();
        configureFrame();
        jFrame.add(new GamePanel());


    }

    private void configureFrame() {
        jFrame.setTitle(GAME_TITLE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }
}
