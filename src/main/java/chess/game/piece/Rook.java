package chess.game.piece;

import java.util.Set;

import chess.game.Coordinate;
import chess.game.Movable;

public class Rook extends Piece implements Movable {

    public Rook(final Color color, final int initRow, final int initCol) {
        super(Type.ROOK, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
