public class LoopsLive {
    

    public static void main(String[] args) {

        // break
        // continue
        // return
        for (int i = 0; i < 5; i += 1) {
            for (int j = 0; j < 5; j++) {
                
                    System.out.print(j);
                

            }
            System.out.print('\n');

        }




        // for (int i = 0; i < 5 || j == 5; i++)
        
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        
        }

        boolean isContinuing = true;
        int z = 0;
        
        while (isContinuing) {
            z++;
            if (z == 20) {
                isContinuing = false;
            }
            System.out.println(z);
        }




        // Challenge 1
        // Foobar
        // count from 1 to 100
        // if i % 3 print "foo"
        // if i is divisble by 5 print "bar"
        // if both divisble by 3 and 5 print "foobar"
        
        // Challenge 2
        // Print out a multiplication table from 1 -12 
        // HINT: use nested for-loops to create rows/columns
        // 1 2 3 ..
        // 2 4 6..
        // 3 6 9...

        // Challenge 3 - while loop
        // Design a guessing game between 3 numbers. 
        // if you guess the number correctly then you win
        // if not then keep playing the game.
        // Example: answer is 2
        // input: 1 -> "wrong answer"
        // input: 2 -> "correct answer"



    }
}



