package pieces;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

import model.Board;

public class Bishop extends AbstractPiece {

	public String possibleMoves(int i, int l){
		String list=""; 
		String oldPiece;
        int r = i;
        int c = l;
        int temp = 1;
        
        for(int j = -1; j <= 1 ; j+=2){
        	for(int k = -1; k <= 1 ; k+=2){
            	try{
            		while(" ".equals(Board.chessBoard[r+temp*j][c+temp*k])){
            			
            			oldPiece = Board.chessBoard[r+temp*j][c+temp*k];
            			Board.chessBoard[r][c] = " ";
            			Board.chessBoard[r+temp*j][c+temp*k] = "B";
            			
            			 if (isKingSafe()) {
	                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
	                        }
            			 
            			 Board.chessBoard[r][c] = "B";
            			 Board.chessBoard[r+temp*j][c+temp*k] = oldPiece;
            			temp++;
            		}
            		if(Character.isLowerCase(Board.chessBoard[r+temp*j][c+temp*k].charAt(0))){
            			oldPiece = Board.chessBoard[r+temp*j][c+temp*k];
            			Board.chessBoard[r][c] = " ";
            			Board.chessBoard[r+temp*j][c+temp*k] = "B";
            			
            			 if (isKingSafe()) {
	                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece+ " ";
	                        }
            			 
            			 Board.chessBoard[r][c] = "B";
            			 Board.chessBoard[r+temp*j][c+temp*k] = oldPiece;
            		}
            		
            	}catch (Exception e){}
            	temp = 1;
            }
        }
        return list;
	}
}
