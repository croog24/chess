package chess;

public class Board {

    private static final int DIMENSION = 8;

    private final Square[][] squares;
    private final Pieces pieces;

    public Board() {
        this.squares = new Square[DIMENSION][DIMENSION];
        this.pieces = new Pieces();
    }

    public void reset() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                squares[i][j] = new Square(i, j);
            }
        }

        initPieces();
    }

    private void initPieces() {
        squares[1][0].setCurrPiece(pieces.getW1Pawn());
        squares[1][1].setCurrPiece(pieces.getW2Pawn());
        squares[1][2].setCurrPiece(pieces.getW3Pawn());
        squares[1][3].setCurrPiece(pieces.getW4Pawn());
        squares[1][4].setCurrPiece(pieces.getW5Pawn());
        squares[1][5].setCurrPiece(pieces.getW6Pawn());
        squares[1][6].setCurrPiece(pieces.getW7Pawn());
        squares[1][7].setCurrPiece(pieces.getW8Pawn());
        squares[0][0].setCurrPiece(pieces.getW1Rook());
        squares[0][1].setCurrPiece(pieces.getW1Knight());
        squares[0][2].setCurrPiece(pieces.getW1Bishop());
        squares[0][3].setCurrPiece(pieces.getWQueen());
        squares[0][4].setCurrPiece(pieces.getWKing());
        squares[0][5].setCurrPiece(pieces.getW2Knight());
        squares[0][6].setCurrPiece(pieces.getW2Bishop());
        squares[0][7].setCurrPiece(pieces.getW2Rook());

        squares[7][0].setCurrPiece(pieces.getB1Pawn());
        squares[7][1].setCurrPiece(pieces.getB2Pawn());
        squares[7][2].setCurrPiece(pieces.getB3Pawn());
        squares[7][3].setCurrPiece(pieces.getB4Pawn());
        squares[7][4].setCurrPiece(pieces.getB5Pawn());
        squares[7][5].setCurrPiece(pieces.getB6Pawn());
        squares[7][6].setCurrPiece(pieces.getB7Pawn());
        squares[7][7].setCurrPiece(pieces.getB8Pawn());
        squares[8][0].setCurrPiece(pieces.getB1Rook());
        squares[8][1].setCurrPiece(pieces.getB1Knight());
        squares[8][2].setCurrPiece(pieces.getB1Bishop());
        squares[8][3].setCurrPiece(pieces.getBQueen());
        squares[8][4].setCurrPiece(pieces.getBKing());
        squares[8][5].setCurrPiece(pieces.getB2Knight());
        squares[8][6].setCurrPiece(pieces.getB2Bishop());
        squares[8][7].setCurrPiece(pieces.getB2Rook());
    }

}
