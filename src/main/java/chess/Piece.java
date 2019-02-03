package chess;

import java.util.Objects;

public class Piece {

    public static enum Type {
        PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING
    }

    public static enum Color {
        WHITE, BLACK;
    }

    public static Piece EMPTY = new Piece();

    private final Type type;
    private final Color color;

    public Piece(final Type type, final Color color) {
        this.type = Objects.requireNonNull(type);
        this.color = Objects.requireNonNull(color);
    }

    private Piece() {
        this.type = null;
        this.color = null;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

}
