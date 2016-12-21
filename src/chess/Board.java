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
    /*private final Piece wPieces[];
    private final Piece bPieces[];*/
    
    public Board() {
        this.square = new Square[128];
        /*this.wPieces = new Piece[16];
        this.bPieces = new Piece[16];*/
        
        for(int i = 0; i < 128; i++)
            this.square[i] = new Square(i);
    }
    
    // 0x88 board
    public void init() {
        for(int i = 0; i < 8; i++) {
            // white pawns
            /*this.wPieces[i] = new Pawn(i + 16, 'p', 'w');
            this.square[i + 16].piece = this.wPieces[i];*/
            
            this.square[i + 16].piece = new Pawn(i + 16, 'P', 'w');
            
            // black pawns
            /*this.bPieces[i] = new Pawn(i + 6*16, 'p', 'b');
            this.square[i + 6*16].piece = this.bPieces[i];*/
            
            this.square[i + 6*16].piece = new Pawn(i + 6*16, 'p', 'b');
        }
        
        // white rooks
        this.square[0].piece = new Rook(0, 'R', 'w');
        this.square[7].piece = new Rook(7, 'R', 'w');
        
        // black rooks
        this.square[7*16].piece = new Rook(7*16, 'r', 'b');
        this.square[7*16 + 7].piece = new Rook(7*16 + 7, 'r', 'b');
        
        // white knights
        this.square[1].piece = new Knight(1, 'N', 'w');
        this.square[6].piece = new Knight(6, 'N', 'w');

        // black knights
        this.square[7*16 + 1].piece = new Knight(7*16 + 1, 'n', 'b');
        this.square[7*16 + 6].piece = new Knight(7*16 + 6, 'n', 'b');
        
        // white bishops
        this.square[2].piece = new Knight(2, 'B', 'w');
        this.square[5].piece = new Knight(5, 'B', 'w');

        // black bishops
        this.square[7*16 + 2].piece = new Knight(7*16 + 2, 'b', 'b');
        this.square[7*16 + 5].piece = new Knight(7*16 + 5, 'b', 'b');
        
        // white queen
        this.square[3].piece = new Queen(3, 'Q', 'w');

        // black queen
        this.square[7*16 + 3].piece = new Queen(7*16 + 3, 'q', 'b');
        
        // white king
        this.square[4].piece = new Queen(4, 'K', 'w');

        // black king
        this.square[7*16 + 4].piece = new Queen(7*16 + 4, 'k', 'b');        
    }
    
    public Square getSquare(int sq0x88) {
        return this.square[sq0x88];
    }
    
    public Piece getPiece(int sq0x88) {
        return getSquare(sq0x88).getPiece();
    }
    
    public void move(int fromSquare, int toSquare) {
        if(isInBoard(toSquare)) {
            this.square[toSquare].piece = square[fromSquare].piece;
            this.square[fromSquare].piece = null;
        }
        
    }
    
    public boolean isInBoard(int sq0x88) {      
        return ((sq0x88 & 0x88) == 0);
    }
    
    public void print() {
        int i, j, cont;

        for(i = 7; i >= 0; i--) {
            cont = 0;
            for(j = 0; j < 8; j++) {
                cont++;

                if(getPiece(i*16 + j) == null)
                    System.out.print("0 ");
                else
                    System.out.print(getPiece(i*16 + j).type + " ");
                
                if(cont == 8)
                    System.out.println(" ");
            }
        }
    }
    
}