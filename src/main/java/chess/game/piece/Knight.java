package chess.game.piece;

import java.util.List;

import chess.game.Coordinate;
import chess.game.Movable;

public class Knight extends Piece implements Movable {

    public Knight(final Color color) {
        super(Type.KNIGHT, color);
    }

    @Override
    public List<Coordinate> getMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
