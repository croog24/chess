package chess.game.piece;

import java.util.Set;

import chess.game.Coordinate;
import chess.game.Movable;

public class Bishop extends Piece implements Movable {

    public Bishop(final Color color, final int initRow, final int initCol) {
        super(Type.BISHOP, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        return getUnvalidatedBishopMoves(currPos.getRow(), currPos.getColumn());
    }

    /**
     * Gets all unvalidated moves of a Bishop piece for the given row and column.
     *
     * @param row the row of the bishop
     * @param col the column of the bishop
     * @return a {@code Set} of all possible moves
     */
    public static Set<Coordinate> getUnvalidatedBishopMoves(final int row, final int col) {

        return null;
    }

}
