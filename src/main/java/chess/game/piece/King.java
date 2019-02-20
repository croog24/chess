package chess.game.piece;

import java.util.Set;

import chess.game.Coordinate;

public class King extends Piece {

    public King(final Color color, final int initRow, final int initCol) {
        super(Type.KING, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        final int currRow = currPos.getRow();
        final int currCol = currPos.getColumn();

        final Coordinate up = new Coordinate(currRow + 1, currCol);
        final Coordinate down = new Coordinate(currRow - 1, currCol);
        final Coordinate left = new Coordinate(currRow, currCol - 1);
        final Coordinate right = new Coordinate(currRow, currCol + 1);
        final Coordinate upLeft = new Coordinate(currRow + 1, currCol - 1);
        final Coordinate upRight = new Coordinate(currRow + 1, currCol + 1);
        final Coordinate downLeft = new Coordinate(currRow - 1, currCol - 1);
        final Coordinate downRight = new Coordinate(currRow - 1, currCol + 1);
        return Set.of(up, down, left, right, upLeft, upRight, downLeft, downRight);
    }

}
