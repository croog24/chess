package chess.game.piece;

import java.util.HashSet;
import java.util.Set;

import chess.game.Coordinate;

public class King extends Piece {

    public King(final Color color, final int initRow, final int initCol) {
        super(Type.KING, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        final Set<Coordinate> set = new HashSet<>();
        final int currRow = currPos.getRow();
        final int currCol = currPos.getColumn();

        set.add(new Coordinate(currRow + 1, currCol));
        set.add(new Coordinate(currRow - 1, currCol));
        set.add(new Coordinate(currRow, currCol - 1));
        set.add(new Coordinate(currRow, currCol + 1));
        set.add(new Coordinate(currRow + 1, currCol - 1));
        set.add(new Coordinate(currRow + 1, currCol + 1));
        set.add(new Coordinate(currRow - 1, currCol - 1));
        set.add(new Coordinate(currRow - 1, currCol + 1));

        return set;
    }

}
