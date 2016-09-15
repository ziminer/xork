package com.ziminer.xork.world;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * A tile represents a location in the {@link World}.
 *
 * <p>The player moves from tile to tile to navigate
 * through the world.
 */
public class Tile {

    /**
     * The key uniquely identifies a tile.
     */
    private final String key;

    /**
     * The transitions available from this tile,
     * indexed by the key of the destination tile.
     */
    private final Map<String, TileTransition> transitions = new HashMap<>();

    public Tile(@Nonnull final String key) {
        this.key = key;
    }

    public void addTransition(@Nonnull final TileTransition tileTransition) {
        Objects.requireNonNull(tileTransition);
        transitions.put(tileTransition.targetTile.key, tileTransition);
    }

    public Optional<TileTransition> getTransitionTo(@Nonnull final String key) {
        return Optional.ofNullable(transitions.get(key));
    }

    @Nonnull
    public Collection<TileTransition> getAvailableTransitions() {
        return Collections.unmodifiableCollection(transitions.values());
    }
}
