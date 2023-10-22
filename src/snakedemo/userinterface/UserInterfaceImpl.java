package snakedemo.userinterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static snakedemo.constants.GameConstants.GAME_TITLE;

public class UserInterfaceImpl {
    private final JFrame jFrame;
    private final JPanel jPanel;
    char snakeDirection = 'R';


    Timer timer;

    public UserInterfaceImpl() {
        this.jFrame = new JFrame();
        this.jPanel = new JPanel();
        configurePanel();
        configureFrame();


    }

    private void configureFrame() {
        jFrame.setTitle(GAME_TITLE);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(jPanel);
    }

    private void configurePanel() {
        jPanel.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        jPanel.setBackground(Color.black);
        jPanel.setFocusable(true);
        jPanel.addKeyListener(new MyKeyAdapter());

    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(snakeDirection != 'R') {
                        snakeDirection = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(snakeDirection != 'L') {
                        snakeDirection = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(snakeDirection != 'D') {
                        snakeDirection = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(snakeDirection != 'U') {
                        snakeDirection = 'D';
                    }
                    break;
            }
        }
    }
}
