package chess.game;

import static chess.game.Board.DIMENSION;
import static chess.game.piece.Piece.Type.BISHOP;
import static chess.game.piece.Piece.Type.QUEEN;
import static chess.game.piece.Piece.Type.ROOK;

import java.util.Set;

import chess.game.piece.Piece;
import chess.game.piece.Piece.Color;
import chess.game.piece.Piece.Type;

/** The primary implementation for determining valid moves and mates. */
public class MoveEngine {

    private static enum Direction {
        UP, DOWN, LEFT, RIGHT, DIAG_UP_LEFT, DIAG_UP_RIGHT, DIAG_DOWN_LEFT, DIAG_DOWN_RIGHT
    }

    private final Board board;

    /**
     * Creates an instance of this engine.
     *
     * @param board the board to calculate from
     */
    public MoveEngine(final Board board) {
        this.board = board;
    }

    /**
     * Calculates the given {@link Piece}'s valid moves.
     *
     * @param piece the {@link Piece} to calculate from
     * @return a {@code Set} of valid moves
     */
    public Set<Coordinate> calculateValidMoves(final Piece piece) {
        final Set<Coordinate> moves = piece.getUnvalidatedMoves();
        moves.removeIf(c -> this.onBoard(c));

        // Optimize by limiting to nearest unblocked row/col
        if (canMoveAcross(piece.getType())) {
            final int lastUpCol = getEndOfColumn(piece, Direction.UP);
            final int lastDownCol = getEndOfColumn(piece, Direction.DOWN);
            moves.removeIf(move -> move.getColumn() < lastDownCol || move.getColumn() > lastUpCol);
            final int lastRightRow = getEndOfRow(piece, Direction.RIGHT);
            final int lastLeftRow = getEndOfRow(piece, Direction.LEFT);
            moves.removeIf(move -> move.getRow() < lastLeftRow || move.getRow() > lastRightRow);
        } else if (canMoveDiagonal(piece.getType())) {
            final Coordinate lastUpLeft = getEndOfDiag(piece, Direction.DIAG_UP_LEFT);
            final Coordinate lastUpRight = getEndOfDiag(piece, Direction.DIAG_UP_RIGHT);
            final Coordinate lastDownLeft = getEndOfDiag(piece, Direction.DIAG_DOWN_LEFT);
            final Coordinate lastDownRight = getEndOfDiag(piece, Direction.DIAG_DOWN_RIGHT);

            moves.removeIf(move -> move.getRow() > lastUpLeft.getRow()
                                && move.getColumn() < lastUpLeft.getColumn());

            moves.removeIf(move -> move.getRow() > lastUpRight.getRow()
                                && move.getColumn() > lastUpRight.getColumn());

            moves.removeIf(move -> move.getRow() < lastDownLeft.getRow()
                                && move.getColumn() < lastDownLeft.getColumn());

            moves.removeIf(move -> move.getRow() < lastDownRight.getRow()
                                && move.getColumn() > lastDownRight.getColumn());
        }

        moves.removeIf(m -> !isOccupiedBySameColor(m, piece.getColor()));
        return moves;
    }

    private boolean onBoard(final Coordinate coord) {
        return coord.getColumn() >= 0
            && coord.getRow() >= 0
            && coord.getColumn() <= DIMENSION
            && coord.getRow() <= DIMENSION;
    }

    private boolean canMoveAcross(final Type type) {
        return type == QUEEN || type == ROOK;
    }

    private boolean canMoveDiagonal(final Type type) {
        return type == QUEEN || type == BISHOP;
    }

    /**
     * Find the farthest column a piece can move in the given direction before being blocked by another piece.
     *
     * @param piece the {@link Piece} in it's current position
     * @param direction the {@link Direction} to check
     * @return the last column that can be moved to
     */
    private int getEndOfColumn(final Piece piece, final Direction direction) {
        final int column = piece.getCurrPos().getColumn();
        final int row = piece.getCurrPos().getRow();
        switch (direction) {
            case UP:
                for (int i = column + 1; i < DIMENSION; i++) {
                    final Piece occupant = board.getPieceAt(new Coordinate(row, i));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor() ? i : i + 1;
                    }
                }
                return DIMENSION;
            case DOWN:
                for (int i = column - 1; i > -1; i--) {
                    final Piece occupant = board.getPieceAt(new Coordinate(row, i));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor() ? i : i - 1;
                    }
                }
                return 0;
            default:
                throw new IllegalArgumentException("Can only find end of column from UP or DOWN");
        }
    }

    /**
     * Find the farthest row a piece can move in the given direction before being blocked by another piece.
     *
     * @param piece the {@link Piece} in it's current position
     * @param direction the {@link Direction} to check
     * @return the last row that can be moved to
     */
    private int getEndOfRow(final Piece piece, final Direction direction) {
        final int column = piece.getCurrPos().getColumn();
        final int row = piece.getCurrPos().getRow();
        switch (direction) {
            case RIGHT:
                for (int i = row + 1; i < DIMENSION; i++) {
                    final Piece occupant = board.getPieceAt(new Coordinate(i, column));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor() ? i : i + 1;
                    }
                }
                return DIMENSION;
            case LEFT:
                for (int i = row - 1; i > -1; i--) {
                    final Piece occupant = board.getPieceAt(new Coordinate(i, column));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor() ? i : i - 1;
                    }
                }
                return 0;
            default:
                throw new IllegalArgumentException("Can only find end of column from LEFT or RIGHT");
        }
    }

    /**
     * Find the farthest diagonal square a piece can move in the given direction before being blocked by another piece.
     *
     * @param piece the {@link Piece} in it's current position
     * @param direction the {@link Direction} to check
     * @return the last coordinate that can be moved to
     */
    private Coordinate getEndOfDiag(final Piece piece, final Direction direction) {
        final int column = piece.getCurrPos().getColumn();
        final int row = piece.getCurrPos().getRow();
        switch (direction) {
            case DIAG_DOWN_LEFT:
                for (int i = row - 1, j = column - 1; i < DIMENSION && j < DIMENSION; i--, j--) {
                    final Piece occupant = board.getPieceAt(new Coordinate(i, j));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor()
                                ? new Coordinate(i + 1, j + 1)
                                : occupant.getCurrPos();
                    }
                }
                break;
            case DIAG_DOWN_RIGHT:
                for (int i = row - 1, j = column + 1; i < DIMENSION && j < DIMENSION; i--, j++) {
                    final Piece occupant = board.getPieceAt(new Coordinate(i, j));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor()
                                ? new Coordinate(i + 1, j - 1)
                                : occupant.getCurrPos();
                    }
                }
                break;
            case DIAG_UP_LEFT:
                for (int i = row + 1, j = column - 1; i < DIMENSION && j < DIMENSION; i++, j--) {
                    final Piece occupant = board.getPieceAt(new Coordinate(i, j));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor()
                                ? new Coordinate(i + 1, j - 1)
                                : occupant.getCurrPos();
                    }
                }
                break;
            case DIAG_UP_RIGHT:
                for (int i = row + 1, j = column + 1; i < DIMENSION && j < DIMENSION; i++, j++) {
                    final Piece occupant = board.getPieceAt(new Coordinate(i, j));
                    if (occupant != null) {
                        return occupant.getColor() == piece.getColor()
                                ? new Coordinate(i + 1, j + 1)
                                : occupant.getCurrPos();
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Can only find end of diag from DIAG based direction");
        }

        return piece.getCurrPos();
    }

    private boolean isOccupiedBySameColor(final Coordinate coord, final Color color) {
        final Piece occupant = board.getPieceAt(coord);
        if (occupant != null) {
            return occupant.getColor() == color;
        }

        return false;
    }

}
