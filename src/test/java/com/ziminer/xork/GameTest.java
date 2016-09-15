package com.ziminer.xork;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ziminer on 2016-09-14.
 */
public class GameTest {

    @Test
    public void testStart() {
        Game game = new Game();
        Assert.assertFalse(game.isRunning());

    }

}
