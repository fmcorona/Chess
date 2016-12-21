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
        //board.print();
        
        board.move(19, 19 + 2*16);
        board.move(20, 20 + 2*16);
        board.move(5, 5 + 4*15);
        board.move(2, 2 + 4*17);
        
        board.print();
    }
    
}
