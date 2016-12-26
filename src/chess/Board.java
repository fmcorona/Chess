/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author Miguel
 */
public class Board {
    private final Square square[];
    private int last_move_fromSquare;
    private int last_move_toSquare;
    private int sq0x88_en_passant;
    
    public Board() {
        this.square = new Square[128];
        this.last_move_fromSquare = -1;
        this.last_move_toSquare = -1;
        this.sq0x88_en_passant = -1;
        
        for(int i = 0; i < 128; i++)
            this.square[i] = new Square(i);
    }
    
    public void init() {
        for(int i = 0; i < 8; i++) {
            // white pawns
            this.square[i + 16].setPiece(new Pawn(i + 16, 'P', 'w'));
            
            // black pawns
            this.square[i + 6*16].setPiece(new Pawn(i + 6*16, 'p', 'b'));
        }
        
        // white rooks
        this.square[0].setPiece(new Rook(0, 'R', 'w'));
        this.square[7].setPiece(new Rook(7, 'R', 'w'));
        
        // black rooks
        this.square[7*16].setPiece(new Rook(7*16, 'r', 'b'));
        this.square[7*16 + 7].setPiece(new Rook(7*16 + 7, 'r', 'b'));
        
        // white knights
        this.square[1].setPiece(new Knight(1, 'N', 'w'));
        this.square[6].setPiece(new Knight(6, 'N', 'w'));

        // black knights
        this.square[7*16 + 1].setPiece(new Knight(7*16 + 1, 'n', 'b'));
        this.square[7*16 + 6].setPiece(new Knight(7*16 + 6, 'n', 'b'));
        
        // white bishops
        this.square[2].setPiece(new Bishop(2, 'B', 'w'));
        this.square[5].setPiece(new Bishop(5, 'B', 'w'));

        // black bishops
        this.square[7*16 + 2].setPiece(new Bishop(7*16 + 2, 'b', 'b'));
        this.square[7*16 + 5].setPiece(new Bishop(7*16 + 5, 'b', 'b'));
        
        // white queen
        this.square[3].setPiece(new Queen(3, 'Q', 'w'));

        // black queen
        this.square[7*16 + 3].setPiece(new Queen(7*16 + 3, 'q', 'b'));
        
        // white king
        this.square[4].setPiece(new King(4, 'K', 'w'));

        // black king
        this.square[7*16 + 4].setPiece(new King(7*16 + 4, 'k', 'b'));
    }
    
    public void setPiece(Piece piece, int sq0x88) {
        this.square[sq0x88].setPiece(piece);
    }
    
    public void setSquareCaptureEnPassant(int sq0x88) {
        this.sq0x88_en_passant = sq0x88;
    }
    
    public void setLastMoveFromSquare(int sq0x88) {
        this.last_move_fromSquare = sq0x88;
    }
    
    public void setLastMoveToSquare(int sq0x88) {
        this.last_move_toSquare = sq0x88;
    }
    
    public Piece getPiece(int sq0x88) {
        return this.square[sq0x88].getPiece();
    }
    
    public char colorPiece(int sq0x88) {
        return getPiece(sq0x88).color();
    }
    
    public char typePiece(int sq0x88) {
        return getPiece(sq0x88).type();
    }
    
    public int lastMoveFromSquare() {
        return this.last_move_fromSquare;
    }
    
    public int lastMoveToSquare() {
        return this.last_move_toSquare;
    }
    
    public int squareCaptureEnPassant() {
        return this.sq0x88_en_passant; 
    }
    
    public void removePiece(int sq0x88) {
        this.square[sq0x88].setPiece(null);
    }
    
    public boolean isInBoard(int sq0x88) {      
        return ((sq0x88 & 0x88) == 0);
    }
    
    public boolean isAvailable(int sq0x88) {
        return (getPiece(sq0x88) == null);
    }
    
    public boolean isInFifthLinea(int sq0x88) {
        return (sq0x88 >= 64 && sq0x88 <= 71);
    }
    
    public boolean isInFourthLinea(int sq0x88) {
        return (sq0x88 >= 48 && sq0x88 <= 55);
    }
    
    public void movePiece(int fromSquare, int toSquare) {
        Piece piece = getPiece(fromSquare);
        
        setPiece(piece, toSquare);
        removePiece(fromSquare);
        piece.update(toSquare);
        
        setLastMoveFromSquare(fromSquare);
        setLastMoveToSquare(toSquare);
    }
    
    public void capturePiece(int fromSquare, int toSquare) {
        movePiece(fromSquare, toSquare);
    }
    
    public void shortCastling(int fromSquare, int toSquare) {
        movePiece(toSquare + 1, fromSquare + 1); // Move rook
        movePiece(fromSquare, toSquare);         // Move king 
    }
    
    public void longCastling(int fromSquare, int toSquare) {
        movePiece(toSquare - 1, toSquare + 1);  // Move rook
        movePiece(fromSquare, toSquare);        // Move king
    }
    
    public void enPassant(int fromSquare, int toSquare) {
        movePiece(fromSquare, toSquare);        
        removePiece(squareCaptureEnPassant());
        setSquareCaptureEnPassant(-1);
    }
    
    public void print() {
        int i, j, count;

        for(i = 7; i >= 0; i--) {
            System.out.print((i + 1) + " ");
            count = 0;
            
            for(j = 0; j < 8; j++) {
                count++;

                if(getPiece(i*16 + j) == null)
                    System.out.print("0 ");
                else
                    System.out.print(typePiece(i*16 + j) + " ");
                
                if(count == 8)
                    System.out.println(" ");
            }
        }
        System.out.println("  a b c d e f g h");
    }
    
}
