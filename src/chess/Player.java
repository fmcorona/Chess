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
public class Player {
    private char color;
    private boolean move_piece;
    private boolean capture_piece;
    private boolean en_passant;
    private boolean short_castling;
    private boolean long_castling;
    
    public Player(char color) {
        this.color = color;
        this.move_piece = false;
        this.capture_piece = false;
        this.en_passant = false;
        this.short_castling = false;
        this.long_castling = false;
    }
    
    public void setColor(char color) {
        this.color = color;
    }
    
    public void setMovePiece(boolean move_piece) {
        this.move_piece = move_piece;
    }
    
    public void setCapturePiece(boolean capture_piece) {
        this.capture_piece = capture_piece;
    }
    
    public void setEnPassant(boolean en_passant) {
        this.en_passant = en_passant;
    }
    
    public void setShortCastling(boolean short_castling) {
        this.short_castling = short_castling;
    }
    
    public void setLongCastling(boolean long_castling) {
        this.long_castling = long_castling;
    }
    
    public char color() {
        return this.color;
    }
    
    public boolean isWhite() {
        return this.color == 'w';
    }
    
    public boolean isBlack() {
        return this.color == 'b';
    }
    
    public boolean movePiece() {
        return this.move_piece;
    }
    
    public boolean capturePiece() {
        return this.capture_piece;
    }
    
    public boolean enPassant() {
        return this.en_passant;
    }
    
    public boolean shortCastling() {
        return this.short_castling;
    }
    
    public boolean longCastling() {
        return this.long_castling;
    }
    
    public boolean move(Board board, int fromSquare, int toSquare) {
        Piece piece = board.getPiece(fromSquare);
        
        if(board.isInBoard(toSquare) && piece != null) {
            if(board.isAvailable(toSquare)) {
                if(piece.isValidMove(board, this, fromSquare, toSquare)) {
                    if(movePiece()) {
                        setMovePiece(false);
                        board.movePiece(piece, fromSquare, toSquare);
                    }
                    else if(shortCastling()) {
                        setShortCastling(false);
                        board.shortCastling(piece, fromSquare, toSquare);
                    }
                    else if(longCastling()) {
                        setLongCastling(false);
                        board.longCastling(piece, fromSquare, toSquare);
                    }
                }
            }
            else if(board.colorPiece(toSquare) != color() && piece.isValidCapture(board, this, fromSquare, toSquare)) {
                setCapturePiece(false);
                board.capturePiece(piece, fromSquare, toSquare);
            }
        }
        
        return false;
    }
    
}
