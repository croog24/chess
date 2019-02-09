package chess.game;

import chess.game.piece.Bishop;
import chess.game.piece.King;
import chess.game.piece.Knight;
import chess.game.piece.Pawn;
import chess.game.piece.Piece;
import chess.game.piece.Piece.Color;
import chess.game.piece.Queen;
import chess.game.piece.Rook;

/** A collection of {@link Piece}s. */
public class Pieces {

    private final Piece w1Pawn;
    private final Piece w2Pawn;
    private final Piece w3Pawn;
    private final Piece w4Pawn;
    private final Piece w5Pawn;
    private final Piece w6Pawn;
    private final Piece w7Pawn;
    private final Piece w8Pawn;
    private final Piece w1Knight;
    private final Piece w2Knight;
    private final Piece w1Bishop;
    private final Piece w2Bishop;
    private final Piece w1Rook;
    private final Piece w2Rook;
    private final Piece wQueen;
    private final Piece wKing;

    private final Piece b1Pawn;
    private final Piece b2Pawn;
    private final Piece b3Pawn;
    private final Piece b4Pawn;
    private final Piece b5Pawn;
    private final Piece b6Pawn;
    private final Piece b7Pawn;
    private final Piece b8Pawn;
    private final Piece b1Knight;
    private final Piece b2Knight;
    private final Piece b1Bishop;
    private final Piece b2Bishop;
    private final Piece b1Rook;
    private final Piece b2Rook;
    private final Piece bQueen;
    private final Piece bKing;

    public Pieces() {
        w1Pawn = new Pawn(Color.WHITE);
        w2Pawn = new Pawn(Color.WHITE);
        w3Pawn = new Pawn(Color.WHITE);
        w4Pawn = new Pawn(Color.WHITE);
        w5Pawn = new Pawn(Color.WHITE);
        w6Pawn = new Pawn(Color.WHITE);
        w7Pawn = new Pawn(Color.WHITE);
        w8Pawn = new Pawn(Color.WHITE);
        w1Knight = new Knight(Color.WHITE);
        w2Knight = new Knight(Color.WHITE);
        w1Bishop = new Bishop(Color.WHITE);
        w2Bishop = new Bishop(Color.WHITE);
        w1Rook = new Rook(Color.WHITE);
        w2Rook = new Rook(Color.WHITE);
        wQueen = new Queen(Color.WHITE);
        wKing = new King(Color.WHITE);

        b1Pawn = new Pawn(Color.BLACK);
        b2Pawn = new Pawn(Color.BLACK);
        b3Pawn = new Pawn(Color.BLACK);
        b4Pawn = new Pawn(Color.BLACK);
        b5Pawn = new Pawn(Color.BLACK);
        b6Pawn = new Pawn(Color.BLACK);
        b7Pawn = new Pawn(Color.BLACK);
        b8Pawn = new Pawn(Color.BLACK);
        b1Knight = new Knight(Color.BLACK);
        b2Knight = new Knight(Color.BLACK);
        b1Bishop = new Bishop(Color.BLACK);
        b2Bishop = new Bishop(Color.BLACK);
        b1Rook = new Rook(Color.BLACK);
        b2Rook = new Rook(Color.BLACK);
        bQueen = new Queen(Color.BLACK);
        bKing = new King(Color.BLACK);
    }

    public Piece getW1Pawn() {
        return w1Pawn;
    }

    public Piece getW2Pawn() {
        return w2Pawn;
    }

    public Piece getW3Pawn() {
        return w3Pawn;
    }

    public Piece getW4Pawn() {
        return w4Pawn;
    }

    public Piece getW5Pawn() {
        return w5Pawn;
    }

    public Piece getW6Pawn() {
        return w6Pawn;
    }

    public Piece getW7Pawn() {
        return w7Pawn;
    }

    public Piece getW8Pawn() {
        return w8Pawn;
    }

    public Piece getW1Knight() {
        return w1Knight;
    }

    public Piece getW2Knight() {
        return w2Knight;
    }

    public Piece getW1Bishop() {
        return w1Bishop;
    }

    public Piece getW2Bishop() {
        return w2Bishop;
    }

    public Piece getW1Rook() {
        return w1Rook;
    }

    public Piece getW2Rook() {
        return w2Rook;
    }

    public Piece getWQueen() {
        return wQueen;
    }

    public Piece getWKing() {
        return wKing;
    }

    public Piece getB1Pawn() {
        return b1Pawn;
    }

    public Piece getB2Pawn() {
        return b2Pawn;
    }

    public Piece getB3Pawn() {
        return b3Pawn;
    }

    public Piece getB4Pawn() {
        return b4Pawn;
    }

    public Piece getB5Pawn() {
        return b5Pawn;
    }

    public Piece getB6Pawn() {
        return b6Pawn;
    }

    public Piece getB7Pawn() {
        return b7Pawn;
    }

    public Piece getB8Pawn() {
        return b8Pawn;
    }

    public Piece getB1Knight() {
        return b1Knight;
    }

    public Piece getB2Knight() {
        return b2Knight;
    }

    public Piece getB1Bishop() {
        return b1Bishop;
    }

    public Piece getB2Bishop() {
        return b2Bishop;
    }

    public Piece getB1Rook() {
        return b1Rook;
    }

    public Piece getB2Rook() {
        return b2Rook;
    }

    public Piece getBQueen() {
        return bQueen;
    }

    public Piece getBKing() {
        return bKing;
    }

}
