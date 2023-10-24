package snakedemo.userinterface;

import snakedemo.computationLogic.GameLogic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import static snakedemo.constants.GameConstants.*;

public class GamePanel extends JPanel implements ActionListener{
    GameLogic gameLogic;
    Timer timer;

    GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        gameLogic = new GameLogic();
        timer = new Timer(DELAY,this);
        startGame();

    }

    private void startGame() {
        gameLogic.initializeGame();
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(gameLogic.isRunning()) {
			/*
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			*/
            g.setColor(Color.red);
            g.fillOval(gameLogic.getAppleX(), gameLogic.getAppleY(), UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< gameLogic.getBodyParts();i++) {
                if(i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    g.setColor(new Color(45,180,0));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.red);
            g.setFont( new Font("Ink Free",Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+gameLogic.getApplesEaten(), (SCREEN_WIDTH - metrics.stringWidth("Score: "+gameLogic.getApplesEaten()))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }

    public void gameOver(Graphics g) {
        //Score
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gameLogic.updateGame();
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    gameLogic.setDirection('L');
                    break;
                case KeyEvent.VK_RIGHT:
                    gameLogic.setDirection('R');
                    break;
                case KeyEvent.VK_UP:
                    gameLogic.setDirection('U');
                    break;
                case KeyEvent.VK_DOWN:
                    gameLogic.setDirection('D');
                    break;
            }
        }
    }
}