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
public class Square {
    private int rank;
    private int file;
    private int sq0x88;
    private Piece piece;
    
    public Square(int sq0x88) {
        this.rank = sq0x88 >> 4;
        this.file = sq0x88 & 7;
        this.sq0x88 = sq0x88;
        this.piece = null;
    }
    
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public int getRank() {
        return this.rank;
    }
    
    public void setFile(int file) {
        this.file = file;
    }
    
    public int getFile() {
        return this.file;
    }
    
    public void setSquareIndex(int rank, int file) {
        this.sq0x88 = 16 * rank + file;
    }
    
    public int getSquareIndex() {
        return this.sq0x88;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public Piece getPiece() {
        return this.piece;
    }
            
}
