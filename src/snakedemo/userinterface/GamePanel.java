package snakedemo.userinterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

import snakedemo.constants.GameConstants;

import static snakedemo.constants.GameConstants.UNIT_SIZE;

public class GamePanel extends JPanel implements ActionListener {

    GamePanel(){
        startGame();
    }
    public void startGame() {

        running = true;
        timer = new Timer(GameConstants.DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(running) {
			/*
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			*/
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< bodyParts;i++) {
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
            g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
