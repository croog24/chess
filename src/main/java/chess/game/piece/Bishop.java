package chess.game.piece;

import java.util.HashSet;
import java.util.Set;

import chess.game.Board;
import chess.game.BoundsCheck;
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
        final Set<Coordinate> moves = new HashSet<>();

        for (int i = 1; i < Board.DIMENSION; i++) {
            final int rowRight = row + i;
            final int rowLeft = row - i;
            final int colUp = col + i;
            final int colDown = col - i;

            if (BoundsCheck.withinBoard(rowRight, colUp)) {
                moves.add(new Coordinate(rowRight, colUp));
            }

            if (BoundsCheck.withinBoard(rowLeft, colUp)) {
                moves.add(new Coordinate(rowLeft, colUp));
            }

            if (BoundsCheck.withinBoard(rowRight, colDown)) {
                moves.add(new Coordinate(rowRight, colDown));
            }

            if (BoundsCheck.withinBoard(rowLeft, colDown)) {
                moves.add(new Coordinate(rowLeft, colDown));
            }
        }

        return moves;
    }

    public static void main(final String[] args) {
        for (final Coordinate c : Bishop.getUnvalidatedBishopMoves(4, 2)) {
            System.out.println(c);
        }
    }

}
