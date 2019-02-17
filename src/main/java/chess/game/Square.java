package chess.game;

import chess.game.piece.Piece;

public class Square {

    private final int row;
    private final int column;
    private Piece currPiece;

    public Square(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Piece getCurrPiece() {
        if (currPiece == null) {
            return Piece.EMPTY;
        }
        return currPiece;
    }

    public void setCurrPiece(final Piece piece) {
        this.currPiece = piece;
    }

}
