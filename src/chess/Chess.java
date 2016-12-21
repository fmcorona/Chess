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
        // TODO code application logic here
        
        Board board = new Board();
        board.init();
        //board.print();
        
        board.move(19, 19 + 2*16);
        board.move(20, 20 + 2*16);
        board.move(5, 5 + 4*15);
        board.move(2, 2 + 4*17);
        
        board.print();
        
        
        
        /*Pawn pawn = new Pawn(2, 0, 'p', 'b');
        
        pawn.info();        
        pawn.move(5, 8);        
        pawn.info();
        
        System.out.println("Rank " + board.getSquare(17).getRank() + ", File"
        + board.getSquare(17).getFile() + ", Piece = " + board.getSquare(17).piece.type);
        
        System.out.println("Is in Board " + board.isInBoard(3));*/
    }
    
}
