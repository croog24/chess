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
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                squares[i][j] = new Square(i, j);
            }
        }
        this.state = State.NEUTRAL;
    }

    /** Resets the current board. */
    public void reset() {
        for (int i = 2; i < 7; i++) {
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

        squares[6][0].setCurrPiece(new Pawn(BLACK, 6, 0));
        squares[6][1].setCurrPiece(new Pawn(BLACK, 6, 1));
        squares[6][2].setCurrPiece(new Pawn(BLACK, 6, 2));
        squares[6][3].setCurrPiece(new Pawn(BLACK, 6, 3));
        squares[6][4].setCurrPiece(new Pawn(BLACK, 6, 4));
        squares[6][5].setCurrPiece(new Pawn(BLACK, 6, 5));
        squares[6][6].setCurrPiece(new Pawn(BLACK, 6, 6));
        squares[6][7].setCurrPiece(new Pawn(BLACK, 6, 7));
        squares[7][0].setCurrPiece(new Rook(BLACK, 7, 0));
        squares[7][1].setCurrPiece(new Knight(BLACK, 7, 1));
        squares[7][2].setCurrPiece(new Bishop(BLACK, 7, 2));
        squares[7][3].setCurrPiece(new Queen(BLACK, 7, 3));
        squares[7][4].setCurrPiece(new King(BLACK, 7, 4));
        squares[7][5].setCurrPiece(new Knight(BLACK, 7, 5));
        squares[7][6].setCurrPiece(new Bishop(BLACK, 7, 6));
        squares[7][7].setCurrPiece(new Rook(BLACK, 7, 7));
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(state);
        // Each square is 5x3 dashes large
        final String line = "\n---------------------------------\n";
        sb.append(line);
        for (int i = DIMENSION - 1; i >= 0; i--) {
            for (int j = 0; j < DIMENSION; j++) {
                final Piece p = squares[i][j].getCurrPiece();
                final String value = p == null ? "   " : " " + p.getType().getAbbreviation() + " ";
                sb.append("|" + value);
            }
            sb.append("|");
            sb.append(line);
        }

        return sb.toString();
    }

}
