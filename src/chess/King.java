/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static java.lang.Math.abs;

/**
 *
 * @author Miguel
 */
public class King extends Piece {
    
    public King(int sq0x88, char type, char color) {
        super(sq0x88, type, color);
    }
    
    @Override
    public boolean isValidMove(Board board, Player player, int fromSquare, int toSquare) {
        // -17, -16, -15, -1, +1, +15, +16, +17 (white and black)
        int inc = toSquare - fromSquare, step;
        
        // Diagonal movement
        if(inc%15 == 0) {
            step = inc/15;
            
            if(abs(step) == 1 && board.isAvailable(toSquare))
                return true;
        }
        
        // Diagonal movement
        if(inc%17 == 0 ) {
            step = inc/17;
            
            if(abs(step) == 1 && board.isAvailable(toSquare))
                return true;
        }
        
        // Horizontal movement
        if(inc > -8 && inc < 8) {
            step = inc;
            
            if(abs(step) == 1 && board.isAvailable(toSquare))
                return true;
        }        
        
        //Vertical movement
        if(inc%16 == 0) {
            step = inc/16;
            
            if(abs(step) == 1 && board.isAvailable(toSquare))
                return true;
        }
        
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        int inc = toSquare - fromSquare, step;
        
        // Diagonal capture
        if(inc%15 == 0) {
            step = inc/15;
            
            if(abs(step) == 1)
                return true;
        }
        
        // Diagonal capture
        if(inc%17 == 0 ) {
            step = inc/17;
            
            if(abs(step) == 1)
                return true;
        }
        
        // Horizontal capture
        if(inc > -8 && inc < 8) {
            step = inc;
            
            if(abs(step) == 1)
                return true;
        }        
        
        //Vertical movement
        if(inc%16 == 0) {
            step = inc/16;
            
            if(abs(step) == 1)
                return true;
        }
        
        return false;
    }
    
}
