# CS213
Rutgers University - CS213 Software Methodology

For this assignment you will explore how to apply the design ideas learned in class to design and implement a board game. You will work individually on this assignment. Read the DCS you are responsible for this. In particular, note that **"All Violations of the Academic Integrity Policy will be reported by the instructor to the appropriate Dean".**
You will implement the game of Chess for two players. Your program, when launched, should draw the board using the terminal and prompt whomever's turn it is (white or black) for a move. Once the move is executed, the move should be played and the new board drawn, and the other player queried.

Output
The board should be drawn on the screen with with ascii art in some sort of grid. Everything should be easily viewable in a standard sized terminal with 80 columns and 24 rows. The identity of each piece, color and type, must be easily discernible from the display. If the player whose turn it is is in check, that must be reported. The details are left to you.
Every piece must know what moves are allowed on it. If a player attempts an illegal move on a piece, your program should not execute the move, but instead, print an explanatory message detailing all legal moves the piece can make from the current position.
When a move is made, and it puts the opponent's King under check, your program should print "Check" before asking for the opponent's move.
If a checkmate or stalemate is detected, your program should print "Checkmate" or "Stalemate".
The last thing before termination should be a display of "Black wins", "White wins" or "Draw".

Input
Your program needs to accept input of the form "FileRank FileRank", where the first file (column) and rank (row) are the coordinates of the piece to be moved, and the second file and rank are the coordinates of where it should end up.
The figure immediately below should make it clear which rank and file combinations belong to which squares. The white pieces always initially occupy ranks 1 and 2. The black pieces always initially occupy ranks 7 and 8. The queen always starts on the d file.

As an example, advancing the white king's pawn two spaces would be input as "e2 e4".

A castling move is indicated by specifying where the king begins and ends. So, white castling king's side would be "e1 g1".

A pawn promotion is indicated by putting the piece to be promoted to after the move. So, promoting a pawn to a knight might be "g7 g8 N". If no promotion is indicated, it is assumed to be a queen.

    bR bN bB bQ bK bB bN bR 8
    bp bp bp bp bp bp bp bp 7
       ##    ##    ##    ## 6
    ##    ##    ##    ##    5
       ##    ##    ##    ## 4
    ##    ##    ##    ##    3 
    wp wp wp wp wp wp wp wp 2
    wR wN wB wQ wK wB wN wR 1
     a  b  c  d  e  f  g  h

    White's move: e2 e4

    bR bN bB bQ bK bB bN bR 8
    bp bp bp bp bp bp bp bp 7
       ##    ##    ##    ## 6
    ##    ##    ##    ##    5
       ##    ## wp ##    ## 4
    ##    ##    ##    ##    3
    wp wp wp wp    wp wp wp 2
    wR wN wB wQ wK wB wN wR 1
     a  b  c  d  e  f  g  h

    Black's move: e7 e5

    bR bN bB bQ bK bB bN bR 8
    bp bp bp bp ## bp bp bp 7
       ##    ##    ##    ## 6
    ##    ##    bp    ##    5
       ##    ## wp ##    ## 4
    ##    ##    ##    ##    3
    wp wp wp wp    wp wp wp 2
    wR wN wB wQ wK wB wN wR 1
     a  b  c  d  e  f  g  h

    White's move:

Ending the game
If checkmate occurs, the game shall end immediately with the result reported. A player may resign by entering "resign". A player may offer a draw by appending "draw?" to the end of an otherwise regular move. The draw may be accepted by the other player submitting "draws" as the entirety of his or her next move. There will be no automatic draws (due to unchanging positions over long periods of time, etc).

Grading
Correctness, 75 pts: Implementation of all required functionality including drawing the board
Design, 5 pts: Appropriate application of object-oriented design ideas you have learned. Although design points are low, our experience is that if you design your solution badly, you will have a lot of trouble implementing/debugging it.

Submission
Name your project Chess. Use packages as necessary. Name your main class Chess. Make sure you record your name in each Java file with the @author Javadoc tag. Zip your project source into a zip archive called chess.zip (see Eclipse tab, under "Zipping up a Project") and submit this file to Sakai.
