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
    int rank;
    int file;
    int sq0x88;
    char type;
    char color;

    /*public Piece(int rank, int file, char type, char color) {
        this.rank = rank;
        this.file = file;
        this.square_index = 16 * this.rank + this.file;
        this.type = type;
        this.color = color;
    }*/
    
    public Piece(int sq0x88, char type, char color) {
        this.rank = sq0x88 >> 4;
        this.file = sq0x88 & 7;
        this.sq0x88 = sq0x88;
        this.type = type;
        this.color = color;
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
    
    public char getColor() {
        return this.color;
    }   
    
    public char getType() {
        return this.type;
    }
    
    public void move(int rank, int file) {
        this.rank = rank;
        this.file = file;
        this.sq0x88 = 16 * this.rank + this.file;
    }
    
    public void move(int sq0x88) {
        this.rank = sq0x88 >> 4;
        this.file = sq0x88 & 7;
        this.sq0x88 = sq0x88;
    }
    
}
