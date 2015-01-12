package pieces;

/**
 * 
 * @author Rizwan Chaudry
 *
 */

import model.Board;

public class Pawn extends AbstractPiece{
	
	public String possibleMoves(int i, int l) {
		String list=""; 
		String oldPiece;
	    int r;
	    int c;
	    r = i;
	    c = l;
		
	if(Board.chessBoard[i][l].charAt(0) == 'P'){
        for (int j=-1; j<=1; j+=2) {
            try {//capture
                if (Character.isLowerCase(Board.chessBoard[r-1][c+j].charAt(0)) && i>=2) {
                    oldPiece=Board.chessBoard[r-1][c+j];
                    Board.chessBoard[r][c]=" ";
                    Board.chessBoard[r-1][c+j]="P";
                    if (isKingSafe()) {
                        list=list+r+c+(r-1)+(c+j)+oldPiece + " ";
                    }
                    Board.chessBoard[r][c]="P";
                    Board.chessBoard[r-1][c+j]=oldPiece;
                }
            } catch (Exception e) {}
            try {//promotion && capture
                if (Character.isLowerCase(Board.chessBoard[r-1][c+j].charAt(0)) && i<6) {
                    String[] temp={"Q","R","B","K"};
                    for (int k=0; k<4; k++) {
                        oldPiece=Board.chessBoard[r-1][c+j];
                        Board.chessBoard[r][c]=" ";
                        Board.chessBoard[r-1][c+j]=temp[k];
                        if (isKingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list=list+c+(c+j)+oldPiece+temp[k]+"P"+ " ";
                        }
                        Board.chessBoard[r][c]="P";
                        Board.chessBoard[r-1][c+j]=oldPiece;
                    }
                }
            } catch (Exception e) {}
        }
        try {//move one up
            if (" ".equals(Board.chessBoard[r-1][c]) && i>=2) {
                oldPiece=Board.chessBoard[r-1][c];
                Board.chessBoard[r][c]=" ";
                Board.chessBoard[r-1][c]="P";
                if (isKingSafe()) {
                    list=list+r+c+(r-1)+c+oldPiece;
                }
                Board.chessBoard[r][c]="P";
                Board.chessBoard[r-1][c]=oldPiece;
            }
        } catch (Exception e) {}
        try {//promotion && no capture
            if (" ".equals(Board.chessBoard[r-1][c]) && i<2) {
                String[] temp={"Q","R","B","K"};
                for (int k=0; k<4; k++) {
                    oldPiece=Board.chessBoard[r-1][c];
                    Board.chessBoard[r][c]=" ";
                    Board.chessBoard[r-1][c]=temp[k];
                    if (isKingSafe()) {
                        //column1,column2,captured-piece,new-piece,P
                        list=list+c+c+oldPiece+temp[k]+"P";
                    }
                    Board.chessBoard[r][c]="P";
                    Board.chessBoard[r-1][c]=oldPiece;
                }
            }
        } catch (Exception e) {}
        try {//move two up
            if (" ".equals(Board.chessBoard[r-1][c]) && " ".equals(Board.chessBoard[r-2][c]) && i>=6) {
                oldPiece=Board.chessBoard[r-2][c];
                Board.chessBoard[r][c]=" ";
                Board.chessBoard[r-2][c]="P";
                if (isKingSafe()) {
                    list=list+r+c+(r-2)+c+oldPiece;
                }
                Board.chessBoard[r][c]="P";
                Board.chessBoard[r-2][c]=oldPiece;
            }
        } catch (Exception e) {}
     }
	return list;
    }
}
