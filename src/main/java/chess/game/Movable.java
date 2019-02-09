package chess.game;

public interface Movable {

    /**
     * Moves this object to the given coordinate.
     *
     * @param coord the {@link Coordinate} to move this piece to
     * @return {@code True} if it the move is valid
     */
    boolean move(final Coordinate coord);
}
