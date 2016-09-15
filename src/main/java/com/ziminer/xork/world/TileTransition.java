package com.ziminer.xork.world;

import javax.annotation.Nonnull;

/**
 * A transition to a target {@link Tile}.
 *
 * <p>The source {@link Tile} is implied - it's the
 * {@link Tile} that owns the {@link TileTransition}.
 */
public class TileTransition {

    public final Tile targetTile;

    public final String description;

    public TileTransition(@Nonnull final Tile targetTile,
                          @Nonnull final String description) {
        this.targetTile = targetTile;
        this.description = description;
    }
}
