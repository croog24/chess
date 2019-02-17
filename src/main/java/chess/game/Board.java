package chess.game;

import static java.util.function.Predicate.not;

import java.util.Set;

import chess.game.piece.Bishop;
import chess.game.piece.King;
import chess.game.piece.Knight;
import chess.game.piece.Pawn;
import chess.game.piece.Piece;
import chess.game.piece.Piece.Color;
import chess.game.piece.Queen;
import chess.game.piece.Rook;

/** The chess board. */
public class Board {

    public static final int DIMENSION = 8;

    private final Square[][] squares;

    /** Creates a new Board instance. */
    public Board() {
        this.squares = new Square[DIMENSION][DIMENSION];
    }

    /** Resets the current board. */
    public void reset() {
        for (int i = 2; i <= 6; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                squares[i][j].setCurrPiece(Piece.EMPTY);
            }
        }

        initPieces();
    }

    private void initPieces() {
        squares[1][0].setCurrPiece(new Pawn(Color.WHITE, 1, 0));
        squares[1][1].setCurrPiece(new Pawn(Color.WHITE, 1, 1));
        squares[1][2].setCurrPiece(new Pawn(Color.WHITE, 1, 2));
        squares[1][3].setCurrPiece(new Pawn(Color.WHITE, 1, 3));
        squares[1][4].setCurrPiece(new Pawn(Color.WHITE, 1, 4));
        squares[1][5].setCurrPiece(new Pawn(Color.WHITE, 1, 5));
        squares[1][6].setCurrPiece(new Pawn(Color.WHITE, 1, 6));
        squares[1][7].setCurrPiece(new Pawn(Color.WHITE, 1, 7));
        squares[0][0].setCurrPiece(new Rook(Color.WHITE, 0, 0));
        squares[0][1].setCurrPiece(new Knight(Color.WHITE, 0, 1));
        squares[0][2].setCurrPiece(new Bishop(Color.WHITE, 0, 2));
        squares[0][3].setCurrPiece(new Queen(Color.WHITE, 0, 3));
        squares[0][4].setCurrPiece(new King(Color.WHITE, 0, 4));
        squares[0][5].setCurrPiece(new Knight(Color.WHITE, 0, 5));
        squares[0][6].setCurrPiece(new Bishop(Color.WHITE, 0, 6));
        squares[0][7].setCurrPiece(new Rook(Color.WHITE, 0, 7));

        squares[1][0].setCurrPiece(new Pawn(Color.BLACK, 7, 0));
        squares[1][1].setCurrPiece(new Pawn(Color.BLACK, 7, 1));
        squares[1][2].setCurrPiece(new Pawn(Color.BLACK, 7, 2));
        squares[1][3].setCurrPiece(new Pawn(Color.BLACK, 7, 3));
        squares[1][4].setCurrPiece(new Pawn(Color.BLACK, 7, 4));
        squares[1][5].setCurrPiece(new Pawn(Color.BLACK, 7, 5));
        squares[1][6].setCurrPiece(new Pawn(Color.BLACK, 7, 6));
        squares[1][7].setCurrPiece(new Pawn(Color.BLACK, 7, 7));

        squares[8][0].setCurrPiece(new Rook(Color.BLACK, 8, 0));
        squares[8][1].setCurrPiece(new Knight(Color.BLACK, 8, 1));
        squares[8][2].setCurrPiece(new Bishop(Color.BLACK, 8, 2));
        squares[8][3].setCurrPiece(new Queen(Color.BLACK, 8, 3));
        squares[8][4].setCurrPiece(new King(Color.BLACK, 8, 4));
        squares[8][5].setCurrPiece(new Knight(Color.BLACK, 8, 5));
        squares[8][6].setCurrPiece(new Bishop(Color.BLACK, 8, 6));
        squares[8][7].setCurrPiece(new Rook(Color.BLACK, 8, 7));
    }

    /**
     * Determines whether or not the given piece can move to the given coordinate.
     *
     * @param piece the {@link} piece to move
     * @param coord the {@link Coordinate} to move to
     * @return {@code True} if it is a valid move
     */
    public boolean canMove(final Piece piece, final Coordinate coord) {
        final Set<Coordinate> validMoves = piece.getUnvalidatedMoves();
        validMoves.removeIf(not(this::onBoard));

        if (validMoves.contains(coord)) {
            if (!stateIsCheck(piece.getColor())) {
                return squares[coord.getColumn()][coord.getRow()].getCurrPiece().getColor() != piece.getColor();
            }
        }

        return false;
    }

    private boolean onBoard(final Coordinate coord) {
        return coord.getColumn() >= 0
            && coord.getRow() >= 0
            && coord.getColumn() <= DIMENSION
            && coord.getRow() <= DIMENSION;
    }

    private boolean stateIsCheck(final Color color) {
        // TODO
        return false;
    }

}
