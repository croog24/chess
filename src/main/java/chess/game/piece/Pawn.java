package chess.game.piece;

import java.util.List;

import chess.game.Coordinate;
import chess.game.Movable;

public class Pawn extends Piece implements Movable {

    public Pawn(final Color color) {
        super(Type.PAWN, color);
    }

    @Override
    public List<Coordinate> getMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
