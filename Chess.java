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
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Board board = new Board();
        board.init();
        
        // Pawn +16, -16
        board.move(19, 19 + 2*16);
        board.move(20, 20 + 2*16);
        
        // Bishop -17, -15, +15, +17
        board.move(5, 5 + 5*15);
        board.move(2, 2 + 4*17);
        
        // Knight -33, -31, -18, -14, +14, +18, +31, +33
        board.move(1, 1 + 1*33);
        board.move(6, 6 + 1*31);
        
        // Queen -17, -16, -15, -1, +1, +15, +16, +17
        board.move(3, 3 + 2*16);
        
        // King -17, -16, -15, -1, +1, +15, +16, +17
        board.move(4, 4 + 1*16);
        
        // Rook -16, -1, +1, +16
        board.move(0, 0 + 3*1);
        board.move(7, 7 + 2*(-1));
        
        board.print();
    }
    
}
