package chess.game.piece;

import java.util.HashSet;
import java.util.Set;

import chess.game.Coordinate;

public class Pawn extends Piece {

    public Pawn(final Color color, final int initRow, final int initCol) {
        super(Type.PAWN, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        final Set<Coordinate> set = new HashSet<>();
        final int nextRow = currPos.getRow() + 1;
        final int currCol = currPos.getColumn();

        set.add(new Coordinate(nextRow, currCol));
        set.add(new Coordinate(nextRow, currCol - 1));
        set.add(new Coordinate(nextRow, currCol + 1));
        // TODO en passant
        return set;
    }

}
