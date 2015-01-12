package pieces;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

import model.Board;

public class King extends AbstractPiece {
	
	public static int kingPositionC;
	public static int kingPositionL;

	 public static int returnWKingPosition(){
		 while (!"K".equals(Board.chessBoard[kingPositionC/8][kingPositionC%8])){
			  kingPositionC++;//get King's location
	      }
	      return kingPositionC;
	 }
	 
	 public static int returnBKingPosition(){
		 while (!"k".equals(Board.chessBoard[kingPositionL/8][kingPositionL%8])){
	    	  kingPositionL++;//get king's location
	      }
		 return kingPositionL;
	 }

	public String possibleMoves(int i, int k) {
		    	String list="";
		    	String oldPiece;
		        int r = i;
		        int c = k;
		        for (int j=0; j<9; j++) {
		            if (j!=4) {
		            try {
		                    if (Character.isLowerCase(Board.chessBoard[r-1+j/3][c-1+j%3].charAt(0)) || " ".equals(Board.chessBoard[r-1+j/3][c-1+j%3])) {
		                        oldPiece=Board.chessBoard[r-1+j/3][c-1+j%3];
		                        Board.chessBoard[r][c]=" ";
		                        Board.chessBoard[r-1+j/3][c-1+j%3]="K";
		                        int kingTemp=kingPositionC;
		                        kingPositionC=i+(j/3)*8+j%3-9;
		                        
		                        if (isKingSafe()) {
		                        	if(!oldPiece.equals(" ")){
		                        		list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
									} else {
										list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
									}
		                        }
		                        Board.chessBoard[r][c]="K";
		                        Board.chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
		                        kingPositionC=kingTemp;
		                    }
		                } catch (Exception e) {}
		            }
		        }
		        return list;
		     }
        }