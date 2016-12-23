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
public class Bishop extends Piece {
    
    public Bishop(int sq0x88, char type, char color) {
        super(sq0x88, type, color);
    }
    
    @Override
    public boolean isValidMove(Board board, Player player, int fromSquare, int toSquare) {
        // -17, -15, +15, +17 (white and black)
        System.out.println(" Piece = Bishop");
        int inc = toSquare - fromSquare, steps, i;
        
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
        
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        return isValidMove(board, player, fromSquare, toSquare);
    }
    
}
