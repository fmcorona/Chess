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
public class Knight extends Piece {
    
    public Knight(int sq0x88, char type, char color) {
        super(sq0x88, type, color);
    }
    
    @Override
    public boolean isValidMove(Board board, Player player, int fromSquare, int toSquare) {
        // -33, -31, -18, -14, +14, +18, +31, +33 (white and black)
        int inc = toSquare - fromSquare;
        
        if(inc%14 == 0 && abs(inc/14) == 1)
            return true;
        
        if(inc%18 == 0 && abs(inc/18) == 1)
            return true;
        
        if(inc%31 == 0 && abs(inc/31) == 1)
            return true;
        
        if(inc%33 == 0 && abs(inc/33) == 1)
            return true;
        
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        return isValidMove(board, player, fromSquare, toSquare);
    }
}
