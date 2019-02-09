package chess.game;

import java.util.Objects;

/** Encapsulates a coordinate pair representing a place on the {@link Board}. */
public class Coordinate {

    private final int row;
    private final int column;

    /**
     * Creates a new instance of this object.
     *
     * @param row the row
     * @param column the column
     */
    public Coordinate(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
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
        final Coordinate other = (Coordinate) obj;
        return column == other.column && row == other.row;
    }

    @Override
    public String toString() {
        return "Coordinate [row=" + row + ", column=" + column + "]";
    }

}
