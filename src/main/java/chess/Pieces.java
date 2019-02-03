package chess;

import chess.Piece.Color;
import chess.Piece.Type;

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
        w1Pawn = new Piece(Type.PAWN, Color.WHITE);
        w2Pawn = new Piece(Type.PAWN, Color.WHITE);
        w3Pawn = new Piece(Type.PAWN, Color.WHITE);
        w4Pawn = new Piece(Type.PAWN, Color.WHITE);
        w5Pawn = new Piece(Type.PAWN, Color.WHITE);
        w6Pawn = new Piece(Type.PAWN, Color.WHITE);
        w7Pawn = new Piece(Type.PAWN, Color.WHITE);
        w8Pawn = new Piece(Type.PAWN, Color.WHITE);
        w1Knight = new Piece(Type.KNIGHT, Color.WHITE);
        w2Knight = new Piece(Type.KNIGHT, Color.WHITE);
        w1Bishop = new Piece(Type.BISHOP, Color.WHITE);
        w2Bishop = new Piece(Type.BISHOP, Color.WHITE);
        w1Rook = new Piece(Type.ROOK, Color.WHITE);
        w2Rook = new Piece(Type.ROOK, Color.WHITE);
        wQueen = new Piece(Type.QUEEN, Color.WHITE);
        wKing = new Piece(Type.KING, Color.WHITE);

        b1Pawn = new Piece(Type.PAWN, Color.BLACK);
        b2Pawn = new Piece(Type.PAWN, Color.BLACK);
        b3Pawn = new Piece(Type.PAWN, Color.BLACK);
        b4Pawn = new Piece(Type.PAWN, Color.BLACK);
        b5Pawn = new Piece(Type.PAWN, Color.BLACK);
        b6Pawn = new Piece(Type.PAWN, Color.BLACK);
        b7Pawn = new Piece(Type.PAWN, Color.BLACK);
        b8Pawn = new Piece(Type.PAWN, Color.BLACK);
        b1Knight = new Piece(Type.KNIGHT, Color.BLACK);
        b2Knight = new Piece(Type.KNIGHT, Color.BLACK);
        b1Bishop = new Piece(Type.BISHOP, Color.BLACK);
        b2Bishop = new Piece(Type.BISHOP, Color.BLACK);
        b1Rook = new Piece(Type.ROOK, Color.BLACK);
        b2Rook = new Piece(Type.ROOK, Color.BLACK);
        bQueen = new Piece(Type.QUEEN, Color.BLACK);
        bKing = new Piece(Type.KING, Color.BLACK);
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
