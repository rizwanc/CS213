package pieces;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

import model.Board;

public class Knight extends AbstractPiece {

	public String possibleMoves(int i, int l){
		String list = "";
		String oldPiece;
		int r = i;
		int c = l;
	
	if(Board.chessBoard[i][l].charAt(0) == 'N'){
		for(int j = -1; j <= 1; j+=2){
			for(int k = -1; k <= 1; k+=2){
				try{
					if(Character.isLowerCase(Board.chessBoard[r+j][c+k*2].charAt(0)) || " ".equals(Board.chessBoard[r+j][c+k*2])){
						oldPiece = Board.chessBoard[r+j][c+k*2];
						Board.chessBoard[r][c] = " ";
						
						if(isKingSafe()){
							if(!oldPiece.equals(" ")){
								list=list+r+c+(r+j)+(c+k*2)+oldPiece+" ";

							} else {
								list=list+r+c+(r+j)+(c+k*2)+oldPiece;
							}
						}
						Board.chessBoard[r][c] = "N";
						Board.chessBoard[r+j][c+k*2] = oldPiece;
					}
				}catch(Exception e){}
				try{
					if(Character.isLowerCase(Board.chessBoard[r+j*2][c+k].charAt(0)) || " ".equals(Board.chessBoard[r+j*2][c+k])){
						oldPiece = Board.chessBoard[r+j*2][c+k];
						Board.chessBoard[r][c] = " ";
						
						if(isKingSafe()){
							if(!oldPiece.equals(" ")){
								list=list+r+c+(r+j*2)+(c+k)+oldPiece+" ";
							} else {
								list=list+r+c+(r+j*2)+(c+k)+oldPiece;
							}
						}
						Board.chessBoard[r][c] = "N";
						Board.chessBoard[r+j*2][c+k] = oldPiece;
					}
				}catch(Exception e){}
			  }
		    }
	      }  
       return list;	
	 }
 }
