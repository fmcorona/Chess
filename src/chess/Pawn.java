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
public class Pawn extends Piece {
    
    public Pawn(int sq0x88, char type, char color) {
        super(sq0x88, type, color);
    }
    
    public void info() {
        System.out.println("Pawn: Rank = " + this.rank + ", File = " + this.file + ", Color = " 
                + this.color + ", Square Index = " + this.sq0x88);
    }
    
}
