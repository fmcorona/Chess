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
public class Pawn extends Piece {   
    public Pawn(int sq0x88, char type, char color) {
        super(sq0x88, type, color);
    }
    
    @Override
    public boolean isValidMove(Board board, Player player, int fromSquare, int toSquare) {
        // +16 (white)
        // -16 (black)
        int steps;
        
        if((toSquare - fromSquare) % 16 == 0) {
            steps = (toSquare - fromSquare)/16;
            
            if((steps == 1 && player.color == 'w') || (steps == -1 && player.color == 'b'))
                return true;
        
            if(abs(steps) == 2 && board.isAvailable(fromSquare + 16 * steps/2) && this.first_move)
                return true;
        }
        
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        // 15, 17   (white)
        // -15, -17 (black)
        int diagStep;
        
        if((toSquare - fromSquare) % 15 == 0) {
             diagStep = (toSquare - fromSquare)/15;
             
            if((player.color == 'w' && diagStep == 1) || (player.color == 'b' && diagStep == -1))
                return true;
        }            

        if((toSquare - fromSquare) % 17 == 0) {
            diagStep = (toSquare - fromSquare)/17;
             
            if((player.color == 'w' && diagStep == 1) || (player.color == 'b' && diagStep == -1))
                return true;
        }
        
        return false;
    }
    
}
