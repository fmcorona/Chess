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
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        return false;
    }
    
}
