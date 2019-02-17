package chess.game.piece;

import java.util.Set;

import chess.game.Coordinate;
import chess.game.Movable;

public class Pawn extends Piece implements Movable {

    public Pawn(final Color color, final int initRow, final int initCol) {
        super(Type.PAWN, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {

        final int nextRow = currPos.getRow() + 1;
        final int currCol = currPos.getColumn();

        final Coordinate up = new Coordinate(nextRow, currCol);
        final Coordinate upLeft = new Coordinate(nextRow, currCol - 1);
        final Coordinate upRight = new Coordinate(nextRow, currCol + 1);
        // TODO en passant
        return Set.of(up, upLeft, upRight);
    }

}
