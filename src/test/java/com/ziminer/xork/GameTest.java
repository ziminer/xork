package com.ziminer.xork;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void testStart() {
        Game game = new Game();
        Assert.assertFalse(game.isRunning());

    }

}
