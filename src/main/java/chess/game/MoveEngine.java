package chess.game;

import static chess.game.Board.DIMENSION;
import static chess.game.piece.Piece.Type.QUEEN;
import static chess.game.piece.Piece.Type.ROOK;
import static java.util.function.Predicate.not;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import chess.game.piece.Piece;
import chess.game.piece.Piece.Color;
import chess.game.piece.Piece.Type;

/** The primary implementation for determining valid moves and mates. */
public class MoveEngine {

    private static enum Direction {
        UP, DOWN, LEFT, RIGHT
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
     * @return a {@code List} of valid moves
     */
    public List<Coordinate> calculateValidMoves(final Piece piece) {
        final Set<Coordinate> moves = piece.getUnvalidatedMoves();
        moves.removeIf(not(this::onBoard));

        // Optimize by limiting to nearest unblocked row/col
        if (canMoveAcross(piece.getType())) {
            final int lastUpCol = getEndOfColumn(piece, Direction.UP);
            final int lastDownCol = getEndOfColumn(piece, Direction.DOWN);
            moves.removeIf(move -> move.getColumn() < lastDownCol || move.getColumn() > lastUpCol);
            final int lastRightRow = getEndOfRow(piece, Direction.RIGHT);
            final int lastLeftRow = getEndOfRow(piece, Direction.LEFT);
            moves.removeIf(move -> move.getRow() < lastLeftRow || move.getRow() > lastRightRow);
        }

        return moves
                .parallelStream()
                .filter(move -> !isOccupiedBySameColor(move, piece.getColor()))
                .collect(Collectors.toList());
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

    private boolean isOccupiedBySameColor(final Coordinate coord, final Color color) {
        final Piece occupant = board.getPieceAt(coord);
        if (occupant != null) {
            return occupant.getColor() == color;
        }

        return false;
    }

}
