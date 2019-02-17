package chess.game;

public abstract class BoundsCheck {

    /**
     * @return {@code true} if the given row and column are on the chess board
     */
    public static boolean withinBoard(final int row, final int col) {
        return row >= 0 && col >= 0 && row < Board.DIMENSION && col < Board.DIMENSION;
    }
}
