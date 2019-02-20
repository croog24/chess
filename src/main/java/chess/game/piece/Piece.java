package chess.game.piece;

import java.util.Objects;
import java.util.Set;

import chess.game.Coordinate;

/** The main chess player objects. */
public abstract class Piece {

    /** The type of piece. */
    public static enum Type {
        PAWN, KNIGHT, BISHOP, ROOK, QUEEN, KING
    }

    /** White or Black. */
    public static enum Color {
        WHITE, BLACK;
    }

    private final Type type;
    private final Color color;
    protected Coordinate currPos;

    /**
     * Creates a new instance of a Piece.
     *
     * @param type the {@link Type}
     * @param color the {@link Color}
     * @param initPos the initial {@link Coordinate}
     */
    Piece(final Type type, final Color color, final Coordinate initPos) {
        this.type = Objects.requireNonNull(type);
        this.color = Objects.requireNonNull(color);
        this.currPos = Objects.requireNonNull(initPos);
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

    public void setCurrPos(final Coordinate pos) {
        this.currPos = Objects.requireNonNull(pos);
    }

    public Coordinate getCurrPos() {
        return currPos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, currPos, type);
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
        return color == other.color && Objects.equals(currPos, other.currPos) && type == other.type;
    }

    /**
     * Calculates all possible moves, unvalidated.
     *
     * @return a {@code Set} of possible {@link Coordinates} to move to
     */
    public abstract Set<Coordinate> getUnvalidatedMoves();

}
