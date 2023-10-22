package snakedemo.problemdomain;

import java.util.Random;

import static snakedemo.constants.GameConstants.UNIT_SIZE;

public class Apple {
    int applesEaten;
    int appleX;
    int appleY;

    public Apple(int applesEaten, int appleX, int appleY) {
        this.applesEaten = applesEaten;
        this.appleX = appleX;
        this.appleY = appleY;
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

    public void newApple(){
        Random random = new Random();
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
}
