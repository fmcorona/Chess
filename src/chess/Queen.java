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
public class Queen extends Piece {
    
    public Queen(int sq0x88, char type, char color) {
        super(sq0x88, type, color);
    }
    
    @Override
    public boolean isValidMove(Board board, Player player, int fromSquare, int toSquare) {
        // -17, -16, -15, -1, +1, +15, +16, +17 (white and black)
        int inc = toSquare - fromSquare, steps, i;
        
        // Diagonal movement
        if(inc%15 == 0) {
            steps = inc/15;
            
            if(inc > 0) {
                for(i = 1; i < steps; i++)
                    if(!board.isAvailable(fromSquare + i*15))
                        return false;
            }
            else {
                for(i = -1; i > steps; i--)
                    if(!board.isAvailable(fromSquare + i*15))
                        return false;
            }
            
            return true;
        }
        
        // Diagonal movement
        if(inc%17 == 0 ) {
            steps = inc/17;
            
            if(inc > 0) {
                for(i = 1; i < steps; i++)
                    if(!board.isAvailable(fromSquare + i*17))
                        return false;
            }
            else {
                for(i = -1; i > steps; i--)
                    if(!board.isAvailable(fromSquare + i*17))
                        return false;
            }
            
            return true;
        }
        
        // Horizontal movement
        if(inc > -8 && inc < 8) {
            steps = inc;
            
            if(inc > 0) {
                for(i = 1; i < steps; i++)
                    if(!board.isAvailable(fromSquare + i))
                        return false;
            }
            else {
                for(i = -1; i > steps; i--)
                    if(!board.isAvailable(fromSquare + i))
                        return false;
            }
            
            return true;
        }        
        
        //Vertical movement
        if(inc%16 == 0) {
            steps = inc/16;
            
            if(inc > 0) {
                for(i = 1; i < steps; i++)
                    if(!board.isAvailable(fromSquare + i*16))
                        return false;
            }
            else {
                for(i = -1; i > steps; i--)
                    if(!board.isAvailable(fromSquare + i*16))
                        return false;
            }
            
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        return isValidMove(board, player, fromSquare, toSquare);
    }
    
}
