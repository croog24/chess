package chess.game;

import java.util.Set;

public interface Movable {

    /**
     * Calculates all possible moves, unvalidated.
     *
     * @return a {@code Set} of possible {@link Coordinates} to move to
     */
    Set<Coordinate> getUnvalidatedMoves();
}
