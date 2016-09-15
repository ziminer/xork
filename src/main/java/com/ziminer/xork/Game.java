package com.ziminer.xork;

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
