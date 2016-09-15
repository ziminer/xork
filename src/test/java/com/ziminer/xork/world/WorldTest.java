package com.ziminer.xork.world;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WorldTest {

    @Test
    public void testEmpytGridWorld() {
        final World world = World.newGridWorld(0, 0);
        Assert.assertEquals(0, world.size());
    }

    @Test
    public void testOneByOneGridWorld() {
        final World world = World.newGridWorld(1, 1);
        Assert.assertEquals(1, world.size());
        Assert.assertTrue(world.getTile("0,0").isPresent());

        // Tiles shouldn't have transitions to themselves.
        Assert.assertFalse(world.getTile("0,0").get()
                .getTransitionTo("0,0").isPresent());
    }

    @Test
    public void simpleGridWorldContents() {
        final World world = World.newGridWorld(2, 2);
        Assert.assertEquals(4, world.size());
        for (int x = 0; x < 2; ++x) {
            for (int y = 0; y < 2; ++y) {
                Assert.assertTrue(world.getTile(World.coordToKey(x, y)).isPresent());
            }
        }

        final Tile originTile = world.getTile("0,0").get();
        Assert.assertTrue(originTile.getTransitionTo("0,1").isPresent());
        Assert.assertTrue(originTile.getTransitionTo("1,0").isPresent());
        // Tiles should only have transitions to adjacent tiles,
        // so 0,0 doesn't have a transition to 1,1.
        Assert.assertFalse(originTile.getTransitionTo("1,1").isPresent());

        final Tile endTile = world.getTile("1,1").get();
        Assert.assertTrue(endTile.getTransitionTo("0,1").isPresent());
        Assert.assertTrue(endTile.getTransitionTo("1,0").isPresent());
        Assert.assertFalse(endTile.getTransitionTo("0,0").isPresent());
    }

    @Test
    public void largeGridWorldContents() {
        final int xDimension = 75;
        final int yDimension = 50;
        final World world = World.newGridWorld(xDimension, yDimension);
        Assert.assertEquals(xDimension * yDimension, world.size());

        for (int x = 0; x < xDimension; ++x) {
            for (int y = 0; y < yDimension; ++y) {
                final Tile curTile = world.getTile(World.coordToKey(x, y))
                        .orElseThrow(AssertionFailedError::new);

                // In the simple grid world each tile has transitions to all its neighbours.
                final List<String> expectedNeighbours = new ArrayList<>();
                if (x > 1) {
                    expectedNeighbours.add(World.coordToKey(x - 1, y));
                }
                if (y > 1) {
                    expectedNeighbours.add(World.coordToKey(x, y - 1));
                }
                if (x < xDimension - 1) {
                    expectedNeighbours.add(World.coordToKey(x + 1, y));
                }
                if (y < yDimension - 1) {
                    expectedNeighbours.add(World.coordToKey(x, y + 1));
                }
                expectedNeighbours.forEach(key -> Assert.assertTrue(
                        curTile.getTransitionTo(key).isPresent()));
            }
        }
    }
}
