package snakedemo.problemdomain;

import static snakedemo.constants.GameConstants.GAME_UNITS;

public class Snake {
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;

    boolean running = false;
}
