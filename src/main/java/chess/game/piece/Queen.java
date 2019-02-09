package chess.game.piece;

import java.util.List;

import chess.game.Coordinate;
import chess.game.Movable;

public class Queen extends Piece implements Movable {

    public Queen(final Color color) {
        super(Type.QUEEN, color);
    }

    @Override
    public List<Coordinate> getMoves() {
        // TODO Auto-generated method stub
        return null;
    }

}
