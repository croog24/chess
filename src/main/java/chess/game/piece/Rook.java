package chess.game.piece;

import java.util.List;

import chess.game.Coordinate;
import chess.game.Movable;

public class Rook extends Piece implements Movable {

    public Rook(final Color color) {
        super(Type.ROOK, color);
    }

    @Override
    public List<Coordinate> getMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
