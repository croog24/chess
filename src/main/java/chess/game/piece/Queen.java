package chess.game.piece;

import java.util.Set;

import chess.game.Coordinate;

public class Queen extends Piece {

    public Queen(final Color color, final int initRow, final int initCol) {
        super(Type.QUEEN, color, new Coordinate(initRow, initCol));
    }

    @Override
    public Set<Coordinate> getUnvalidatedMoves() {
        final Set<Coordinate> moves = Rook.getUnvalidatedRookMoves(currPos.getRow(), currPos.getColumn());
        moves.addAll(Bishop.getUnvalidatedBishopMoves(currPos.getRow(), currPos.getColumn()));
        return moves;
    }

}
