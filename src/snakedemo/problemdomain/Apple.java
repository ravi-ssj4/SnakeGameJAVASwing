package snakedemo.problemdomain;

import java.util.Random;

import static snakedemo.constants.GameConstants.*;

public class Apple {
    int applesEaten;
    int appleX;
    int appleY;

    public Apple(int applesEaten, int appleX, int appleY) {
        this.applesEaten = applesEaten;
        this.appleX = appleX;
        this.appleY = appleY;
    }
}
