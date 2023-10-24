package snakedemo.computationLogic;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static snakedemo.constants.GameConstants.*;
import static snakedemo.constants.GameConstants.SCREEN_HEIGHT;

public class GameLogic {
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;


    public void initializeGame() {
        newApple();
        running = true;
    }

    public void updateGame() {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
    }

    public void newApple(){
        Random random = new Random();
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }

    public void setDirection(char newDirection) {
        if (isValidChange(newDirection)) {
            this.direction = newDirection;
        }
    }

    private boolean isValidChange(char newDirection) {
        // This method checks if the direction change is valid.
        // For example, if currently moving RIGHT, you can't immediately go LEFT.
        switch (newDirection) {
            case 'L': return direction != 'R';
            case 'R': return direction != 'L';
            case 'U': return direction != 'D';
            case 'D': return direction != 'U';
            default: return false;
        }
}

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public int getApplesEaten() {
        return applesEaten;
    }

    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public char getDirection() {
        return direction;
    }

    public boolean isRunning() {
        return running;
    }
