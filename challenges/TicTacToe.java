package challenges;

import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {

        //Declare 3x3 2D array:
        char[][] board = new char[3][3];
        //Declare random number generator
        Random rand = new Random();
        //Declare counters for Xs and Os
        int xCounter = 0;
        int oCounter = 0;

        // Part I: populate the tictactoe board 
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                // int placeX = rand.nextInt(2);
                boolean placeX = rand.nextBoolean();

                if (placeX && xCounter < 5) {
                    board[row][col] = 'X';
                    xCounter++;
                } else if (!placeX && oCounter < 4) {
                    board[row][col] = 'O';
                    oCounter++;
                } 
                //In case X or O already hits the counter, 
                //    we need to still fill out the rest of the board
                else if (xCounter < 5) { 
                    board[row][col] = 'X';
                    xCounter++;
                } else {
                    board[row][col] = 'O';
                    oCounter++;
                }
            }
        }

        // Print the board
        System.out.println("Tic-Tac-Toe Board:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Part II: Check for the winner

        // loop through the rows and columns, use the index dynamically:
        for (int i = 0; i < 3; i++) {

            // check rows for winner
            if (board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {

                System.out.println(board[i][0] + " wins");
                return;
            }

            // check columns for winner
            if (board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {

                System.out.println(board[0][i] + " wins");
                return;
            }
        }

        // check one diagonal (top-left to bottom-right)
        if (board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {

            System.out.println(board[0][0] + " wins");
            return;
        }

        // check other diagonal (top-right to bottom-left)
        if (board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {

            System.out.println(board[0][2] + " wins");
            return;
        }

        // no winner found
        System.out.println("Draw (cat’s game)");
    }
}
