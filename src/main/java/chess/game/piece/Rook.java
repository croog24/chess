package chess.game.piece;

import java.util.HashSet;
import java.util.Set;

import chess.game.Board;
import chess.game.Coordinate;
import chess.game.Movable;

public class Rook extends Piece implements Movable {

    public Rook(final Color color, final int initRow, final int initCol) {
        super(Type.ROOK, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        return getUnvalidatedRookMoves(currPos.getRow(), currPos.getColumn());
    }

    /**
     * Gets all unvalidated moves of a Rook piece for the given row and column.
     *
     * @param row the row of the Rook
     * @param col the column of the ROok
     * @return a {@code Set} of all possible moves
     */
    public static Set<Coordinate> getUnvalidatedRookMoves(final int row, final int col) {
        final Set<Coordinate> moves = new HashSet<>();
        for (int i = 0; i < Board.DIMENSION; i++) {
            moves.add(new Coordinate(i, row));
            moves.add(new Coordinate(col, i));
        }

        return moves;
    }

}
