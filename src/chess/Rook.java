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
public class Rook extends Piece {
    
    public Rook(int sq0x88, char type, char color) {
        super(sq0x88, type, color);
    }
    
    @Override
    public boolean isValidMove(Board board, Player player, int fromSquare, int toSquare) {
        // -16, -1, +1, +16 (white and black)
        int inc = toSquare - fromSquare, steps, i;
        player.setMovePiece(false);
        
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
            
            player.setMovePiece(true);
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
            
            player.setMovePiece(true);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        player.setCapturePiece(false);
        
        if(isValidMove(board, player, fromSquare, toSquare)) {
            player.setCapturePiece(true);
            return true;
        }
        return false;
    }
    
}
