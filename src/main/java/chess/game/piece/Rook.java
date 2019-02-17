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
        final int currRow = currPos.getRow();
        final int currCol = currPos.getColumn();

        final Set<Coordinate> moves = new HashSet<>();
        for (int i = 0; i < Board.DIMENSION; i++) {
            moves.add(new Coordinate(i, currCol));
            moves.add(new Coordinate(currRow, i));
        }

        return moves;
    }

}
