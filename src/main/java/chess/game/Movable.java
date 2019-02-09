package chess.game;

import java.util.List;

public interface Movable {

    /**
     * Calculates all possible moves.
     *
     * @return a {@code list} of possible {@link Coordinates} to move to
     */
    List<Coordinate> getMoves();
}
