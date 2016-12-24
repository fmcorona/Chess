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
        int inc = toSquare - fromSquare, steps;
        
        if(inc%16 == 0) {
            steps = inc/16;
            
            if((steps == 1 && player.isWhite()) || (steps == -1 && player.isBlack())) {
                player.setMovePiece(true);
                return true;
            }
                
            
            if(abs(steps) == 2 && board.isAvailable(fromSquare + 16 * steps/2) && isFirstMove()) {
                player.setMovePiece(true);
                return true;
            }
                
        }
        
        if(inc%15 == 0){
            if(inc > 0 && board.isInFifthLinea(fromSquare) 
                    && (board.lastMoveToSquare() - board.lastMoveFromSquare()) == -32 
                    && board.lastMoveToSquare() == fromSquare - 1) {
                board.setSquareCaptureEnPassant(board.lastMoveToSquare());
                player.setEnPassant(true);
                return true;
            }
            if(inc < 0 && board.isInFourthLinea(fromSquare) 
                    && (board.lastMoveToSquare() - board.lastMoveFromSquare()) == 32 
                    && board.lastMoveToSquare() == fromSquare + 1) {
                board.setSquareCaptureEnPassant(board.lastMoveToSquare());
                player.setEnPassant(true);
                return true;
            }
        }
        
        if(inc%17 == 0){
            if(inc > 0 && board.isInFifthLinea(fromSquare) 
                    && (board.lastMoveToSquare() - board.lastMoveFromSquare()) == -32 
                    && board.lastMoveToSquare() == fromSquare + 1) {
                board.setSquareCaptureEnPassant(board.lastMoveToSquare());
                player.setEnPassant(true);
                return true;
            }
            if(inc < 0 && board.isInFourthLinea(fromSquare) 
                    && (board.lastMoveToSquare() - board.lastMoveFromSquare()) == 32 
                    && board.lastMoveToSquare() == fromSquare - 1) {
                board.setSquareCaptureEnPassant(board.lastMoveToSquare());
                player.setEnPassant(true);                
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean isValidCapture(Board board, Player player, int fromSquare, int toSquare) {
        // 15, 17   (white)
        // -15, -17 (black)
        int diagStep;
        player.setCapturePiece(true);
        
        if((toSquare - fromSquare) % 15 == 0) {
            diagStep = (toSquare - fromSquare)/15;
             
            if((player.isWhite() && diagStep == 1) || (player.isBlack() && diagStep == -1))
                return true;
        }            

        if((toSquare - fromSquare) % 17 == 0) {
            diagStep = (toSquare - fromSquare)/17;
            
            if((player.isWhite() && diagStep == 1) || (player.isBlack() && diagStep == -1))
                return true;
        }
        
        player.setCapturePiece(false);
        return false;
    }
    
}
