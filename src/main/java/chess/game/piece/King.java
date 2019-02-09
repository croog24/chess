package chess.game.piece;

import java.util.List;

import chess.game.Coordinate;
import chess.game.Movable;

public class King extends Piece implements Movable {

    public King(final Color color) {
        super(Type.KING, color);
    }

    @Override
    public List<Coordinate> getMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
