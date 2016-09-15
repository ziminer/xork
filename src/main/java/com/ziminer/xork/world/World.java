package com.ziminer.xork.world;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * The {@link World} represents the entire map available
 * to the player for navigation. It's composed of interconnected
 * {@link Tile}s.
 */
public class World {
    private final Map<String, Tile> tiles;

    private World(final Map<String, Tile> tiles) {
        this.tiles = Objects.requireNonNull(tiles);
    }

    public static String coordToKey(int x, int y) {
        return x + "," + y;
    }

    /**
     * Returns a world shaped like a grid, with
     * transitions between adjacent points.
     *
     * <p>The names of the tiles in the world are supplied
     * by {@link World#coordToKey(int, int)}:
     *
     * <p>0,0 is the bottom-left corner.
     *
     * E.g. for a 2 by 2 world:
     *
     * (0,1) - (1,1)
     * |         |
     * (0,0) - (1,0)
     *
     * @param width The width of the world, in tiles.
     * @param height The height of the world, in tiles.
     * @return The newly created {@link World}.
     */
    public static World newGridWorld(int width, int height) {
        // TODO (roman, Sept 14 2016): Make this work.
        throw new IllegalStateException("NOT WORKING YET.");
    }

    public Optional<Tile> getTile(@Nonnull final String key) {
        return Optional.ofNullable(tiles.get(key));
    }

    public int size() {
        return tiles.size();
    }
}
