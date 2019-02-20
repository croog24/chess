package chess.game;

import static chess.game.piece.Piece.Color.BLACK;
import static chess.game.piece.Piece.Color.WHITE;

import chess.game.piece.Bishop;
import chess.game.piece.King;
import chess.game.piece.Knight;
import chess.game.piece.Pawn;
import chess.game.piece.Piece;
import chess.game.piece.Queen;
import chess.game.piece.Rook;

/** The chess board. */
public class Board {

    public static final int DIMENSION = 8;

    private final Square[][] squares;
    private State state;

    /** Creates a new Board instance. */
    public Board() {
        this.squares = new Square[DIMENSION][DIMENSION];
        this.state = State.NEUTRAL;
    }

    /** Resets the current board. */
    public void reset() {
        for (int i = 2; i <= 6; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                squares[i][j].setCurrPiece(null);
            }
        }

        state = State.NEUTRAL;

        initPieces();
    }

    private void initPieces() {
        squares[1][0].setCurrPiece(new Pawn(WHITE, 1, 0));
        squares[1][1].setCurrPiece(new Pawn(WHITE, 1, 1));
        squares[1][2].setCurrPiece(new Pawn(WHITE, 1, 2));
        squares[1][3].setCurrPiece(new Pawn(WHITE, 1, 3));
        squares[1][4].setCurrPiece(new Pawn(WHITE, 1, 4));
        squares[1][5].setCurrPiece(new Pawn(WHITE, 1, 5));
        squares[1][6].setCurrPiece(new Pawn(WHITE, 1, 6));
        squares[1][7].setCurrPiece(new Pawn(WHITE, 1, 7));
        squares[0][0].setCurrPiece(new Rook(WHITE, 0, 0));
        squares[0][1].setCurrPiece(new Knight(WHITE, 0, 1));
        squares[0][2].setCurrPiece(new Bishop(WHITE, 0, 2));
        squares[0][3].setCurrPiece(new Queen(WHITE, 0, 3));
        squares[0][4].setCurrPiece(new King(WHITE, 0, 4));
        squares[0][5].setCurrPiece(new Knight(WHITE, 0, 5));
        squares[0][6].setCurrPiece(new Bishop(WHITE, 0, 6));
        squares[0][7].setCurrPiece(new Rook(WHITE, 0, 7));

        squares[7][0].setCurrPiece(new Pawn(BLACK, 7, 0));
        squares[7][1].setCurrPiece(new Pawn(BLACK, 7, 1));
        squares[7][2].setCurrPiece(new Pawn(BLACK, 7, 2));
        squares[7][3].setCurrPiece(new Pawn(BLACK, 7, 3));
        squares[7][4].setCurrPiece(new Pawn(BLACK, 7, 4));
        squares[7][5].setCurrPiece(new Pawn(BLACK, 7, 5));
        squares[7][6].setCurrPiece(new Pawn(BLACK, 7, 6));
        squares[7][7].setCurrPiece(new Pawn(BLACK, 7, 7));
        squares[8][0].setCurrPiece(new Rook(BLACK, 8, 0));
        squares[8][1].setCurrPiece(new Knight(BLACK, 8, 1));
        squares[8][2].setCurrPiece(new Bishop(BLACK, 8, 2));
        squares[8][3].setCurrPiece(new Queen(BLACK, 8, 3));
        squares[8][4].setCurrPiece(new King(BLACK, 8, 4));
        squares[8][5].setCurrPiece(new Knight(BLACK, 8, 5));
        squares[8][6].setCurrPiece(new Bishop(BLACK, 8, 6));
        squares[8][7].setCurrPiece(new Rook(BLACK, 8, 7));
    }

    /**
     * Get the existing {@link Piece} at the given {@link Coordinate}.
     *
     * @param coord the {@link Coordinate} to check
     * @return the occupying {@link Piece} of {@code null} if empty
     */
    public Piece getPieceAt(final Coordinate coord) {
        return squares[coord.getRow()][coord.getColumn()].getCurrPiece();
    }

    /**
     * Get the current game {@link State}.
     *
     * @return the current state
     */
    public State getState() {
        return state;
    }

}
