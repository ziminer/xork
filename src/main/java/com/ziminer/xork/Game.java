package com.ziminer.xork;

/**
 * Created by ziminer on 2016-09-14.
 */
public class Game {

    private boolean running;

    public Game() {
        this.running = false;
    }

    public void start() {
        running = true;
    }

    public boolean isRunning() {
        return running;
    }
}
