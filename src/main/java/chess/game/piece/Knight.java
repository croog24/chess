package chess.game.piece;

import java.util.HashSet;
import java.util.Set;

import chess.game.Coordinate;
import chess.game.Movable;

public class Knight extends Piece implements Movable {

    public Knight(final Color color, final int initRow, final int initCol) {
        super(Type.KNIGHT, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        final Set<Coordinate> moves = new HashSet<>();
        final int currRow = currPos.getRow();
        final int currCol = currPos.getColumn();

        moves.add(new Coordinate(currRow - 2, currCol - 1));
        moves.add(new Coordinate(currRow - 2, currCol + 1));
        moves.add(new Coordinate(currRow + 2, currCol - 1));
        moves.add(new Coordinate(currRow + 2, currCol + 1));
        moves.add(new Coordinate(currRow + 1, currCol + 2));
        moves.add(new Coordinate(currRow - 1, currCol + 2));
        moves.add(new Coordinate(currRow + 1, currCol - 2));
        moves.add(new Coordinate(currRow - 1, currCol - 2));

        return moves;
    }

}
