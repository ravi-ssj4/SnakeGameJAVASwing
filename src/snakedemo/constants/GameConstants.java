package snakedemo.constants;

public class GameConstants {
    // higher the delay, slower the game is (ie. refresh rate of the snake)
    public static final int DELAY = 175;
    public static final int UNIT_SIZE = 25;
    public static final String GAME_TITLE = "Snake Game";
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    public static final String GAME_COMPLETE = "Congratulations, you win! New game?";
    public static final String ERROR = "An error has occured";

    // size of 1 grid - also size of snake body, apple, etc
    public static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
}
