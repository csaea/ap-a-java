package challenges;

public class TicTacToeProblem
{
    // CREATE AND DISPLAY BOARD

    // Declare a 3 by 3 two-dimensional array of characters to represent the board

    // Initialize a random number generator

    // Declare and initialize two counters:
    // one to track the number of X values placed
    // one to track the number of O values placed

    // FOR each row index from 0 to 2
    //     FOR each column index from 0 to 2
    //         Generate a random value (0 or 1)
    //         IF the random value indicates X AND X has not reached its limit
    //             Place 'X' in the current cell
    //             Increment the X counter
    //         ELSE IF the random value indicates O AND O has not reached its limit
    //             Place 'O' in the current cell
    //             Increment the O counter
    //         ELSE IF X has not reached its limit
    //             Place 'X' in the current cell
    //             Increment the X counter
    //         ELSE
    //             Place 'O' in the current cell
    //             Increment the O counter
    //     END FOR
    // END FOR

    // FOR each row in the board
    //     FOR each column in the row
    //         Print the value at the current row and column
    //     END FOR
    //     Move to the next line
    // END FOR


    // PART II: Check for winner 

    // FOR index from 0 to 2
    //     IF all three values in the current row are equal
    //         Print which symbol won
    //         Stop the program
    //
    //     IF all three values in the current column are equal
    //         Print which symbol won
    //         Stop the program
    // END FOR

    // IF all three values in the main diagonal are equal
    //     Print which symbol won
    //     Stop the program

    // IF all three values in the other diagonal are equal
    //     Print which symbol won
    //     Stop the program

    // If no winning condition was found
    // Print that the game is a draw (cat’s game)
}
