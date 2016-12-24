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
public class Piece {
    private int rank;
    private int file;
    private int sq0x88;
    private final char type;
    private final char color;    
    private boolean first_move;
    
    public Piece(int sq0x88, char type, char color) {
        this.rank = sq0x88 >> 4;
        this.file = sq0x88 & 7;
        this.sq0x88 = sq0x88;
        this.type = type;
        this.color = color;
        this.first_move = true;
    }
    
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public void setFile(int file) {
        this.file = file;
    }
    
    public void setSquareIndex(int rank, int file) {
        this.sq0x88 = 16 * rank + file;
    }
    
    public void setFirstMove(boolean first_move) {
        this.first_move = first_move;
    }
    
    public int getRank() {
        return this.rank;
    }
    
    public int getFile() {
        return this.file;
    }
    
    public int getSquareIndex() {
        return this.sq0x88;
    }
    
    public char color() {
        return this.color;
    }   
    
    public char type() {
        return this.type;
    }
    
    public void update(int sq0x88) {
        this.rank = sq0x88 >> 4;
        this.file = sq0x88 & 7;
        this.sq0x88 = sq0x88;
        this.first_move = false;
    }
    
    public boolean isValidMove(Board board, Player player, int fromSquare, int toSquare) {
        return false;
    }
    
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        return false;
    }
    
    public boolean isFirstMove() {
        return this.first_move;
    }
    
}
