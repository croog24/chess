package chess.game.piece;

import java.util.Set;

import chess.game.Coordinate;
import chess.game.Movable;

public class King extends Piece implements Movable {

    public King(final Color color, final int initRow, final int initCol) {
        super(Type.KING, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
