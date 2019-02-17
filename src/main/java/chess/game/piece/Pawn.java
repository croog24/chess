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
        // TODO Auto-generated method stub
        return null;
    }

}
