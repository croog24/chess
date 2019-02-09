package chess.game;

import java.util.Objects;

public class Piece implements Movable {

    /** The type of piece. */
    public static enum Type {
        PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING
    }

    /** White or Black. */
    public static enum Color {
        WHITE, BLACK;
    }

    public static Piece EMPTY = new Piece();

    private final Type type;
    private final Color color;

    /**
     * Creates a new instance of a Piece.
     *
     * @param type the {@link Type}
     * @param color the {@link Color}
     */
    public Piece(final Type type, final Color color) {
        this.type = Objects.requireNonNull(type);
        this.color = Objects.requireNonNull(color);
    }

    /** Used to create the {@link #EMPTY} piece. */
    private Piece() {
        this.type = null;
        this.color = null;
    }

    /**
     * @return the {@link Type} of this piece
     */
    public Type getType() {
        return type;
    }

    /**
     * @return the {@link Color} of this piece
     */
    public Color getColor() {
        return color;
    }

    @Override
    public boolean move(final Coordinate coord) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        return color == other.color && type == other.type;
    }

    @Override
    public String toString() {
        return "Piece [type=" + type + ", color=" + color + "]";
    }

}
