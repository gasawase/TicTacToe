import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author summergasaway
 */
public class TicTacToe 
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][]=new String[ROW][COL];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
            boolean playAgain = false;

            Scanner in = new Scanner (System.in);
            do
            {
                    play();//plays game
                if (!SafeInput.getYNConfirm(in, "Want to play again? "))//DONE plays again
                {
                    playAgain = true;
                }
            }while (!playAgain);
            
    }
    private static void play ()
    {
            Scanner in = new Scanner (System.in);
            int moveCnt = 0;
            String playerIs = "X";
            int playerMoveRow = 0;
            int playerMoveCol = 0;    
            boolean playing = true;
            System.out.println("Welcome to Tic-Tac-Toe!!");
            clearBoard();
            display(); 
            do
            {
                do 
                {
                    playerMoveRow = SafeInput.getRangedInt(in, "Player " + playerIs + ": what is your horizontal movement? ", 1, 3);
                    playerMoveRow = playerMoveRow - 1;
                    playerMoveCol = SafeInput.getRangedInt(in, "Player " + playerIs + ": what is your vertical movement? ", 1, 3);
                    playerMoveCol = playerMoveCol - 1;
                    if (!isValidMove(playerMoveRow, playerMoveCol))
                    {
                        System.out.println("Please enter a valid move.");
                    }
                }while (!isValidMove(playerMoveRow, playerMoveCol));
                board[playerMoveRow][playerMoveCol] = playerIs;
                moveCnt ++;
                display();
      
                if (isWin(playerIs))
                {
                    System.out.println(playerIs + " won!");
                    playing = false;
                }
                else if (isTie(playerIs, moveCnt))
                {
                    System.out.println("Tie!");
                    playing = false;
                }
                if (playerIs.equals("X"))
                {
                    playerIs = "O";
                }
                else
                {
                    playerIs = "X";
                } 

            }while(playing);//won't stop when a win happens
    }
    private static void clearBoard()//clears board
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col=0; col<COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }  
    private static void display()//displays board
    {
        
        for(int row = 0; row < ROW; row++)
        {
            for(int col=0; col<COL; col++)
            {
                System.out.print(" | " + board[row][col]);
            }
            System.out.println("\n");
        }
    }
    private static boolean isValidMove(int row, int col) //checks for valid move
    {
        boolean validMove = false;
        if(board[row][col].equals(" "))
        {
            validMove = true;
        }
        return validMove;
    }
    private static boolean isWin(String player) //checks for a win
    {
        if(isColWin(player) || isRowWin(player) || isDiagWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin (String player)//checks for a column win specifically 
    {
        for (int col = 0; col < COL; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board [2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player) //checks for row win specifically 
    {
        for (int row = 0; row < ROW; row++)
        {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagWin(String player) //checks for diag win specifically 
    {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        else if((board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)))
                {
                    return true;
                }
        return false;
    }
    private static boolean isTie(String player, int moveCnt)
    {
        if (moveCnt == 9)
        {
            return true;
        }
        else if (moveCnt == 7 && !isWin(player))
        {
            return true;
        }
        return false;
    }


}
